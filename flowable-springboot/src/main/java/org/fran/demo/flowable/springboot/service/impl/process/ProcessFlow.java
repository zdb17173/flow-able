package org.fran.demo.flowable.springboot.service.impl.process;

import com.fasterxml.jackson.core.JsonProcessingException;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.D;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.fran.demo.flowable.springboot.dao.po.AppProcessInstanceData;
import org.fran.demo.flowable.springboot.exceptions.ProcessIllegalAccessException;
import org.fran.demo.flowable.springboot.service.ProcessService;
import org.fran.demo.flowable.springboot.service.impl.loginuser.User;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

//流程前进、后退等流转
@Transactional(rollbackFor = Exception.class)
public abstract class ProcessFlow extends ProcessTaskList implements ProcessService {
    static enum SendBack{
        FORWARD(1),SEND_BACK(2);
        SendBack(int type){
            this.type = type;
        }
        int type;
        int getType(){
            return type;
        }
    }

    @Override
    public void submit(String taskId, String nextOwnerId, Map<String, Object> variables){
        //更新当前taskId
        save(taskId, variables);

        Task task = taskService.createTaskQuery()
                .taskId(taskId).singleResult();
        if(task == null){
            throw new IllegalArgumentException("任务不存在{" + taskId +"}");
        }

        if(task!= null){
            Map<String, Object> param = new HashMap<>();
            param.put("sendBack", SendBack.FORWARD.getType());
            taskService.complete(taskId, param);

            setProcessDataEndTime(taskId);

            if(processIsEnd(task.getProcessInstanceId())){
                //TODO: 流程已经结束 处理后续
            }else{
                List<Task> followTasks = taskService.createTaskQuery()
                        .processInstanceId(task.getProcessInstanceId())
                        .list();
                if(followTasks!= null && followTasks.size() > 0){
                    //目前不处理并行网关的逻辑，只处理单线
                    Task followTask = followTasks.get(0);
                    if(nextOwnerId!= null){//如指定下一个节点由谁处理，直接设置owner
                        followTask.setOwner(nextOwnerId);
                        taskService.saveTask(followTask);
                    }
                    AppProcessInstanceData appProcessInstanceData = new AppProcessInstanceData();
                    try {
                        appProcessInstanceData.setData(mapToJsonBytes(variables));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    //appProcessInstanceData.setCreator();
                    appProcessInstanceData.setTaskName(followTask.getName());
                    appProcessInstanceData.setTaskId(followTask.getId());
                    appProcessInstanceData.setInstanceId(followTask.getProcessInstanceId());
                    appProcessInstanceData.setCreateTime(new Date());
                    appProcessInstanceDataMapper.insert(appProcessInstanceData);
                }
            }
        }
    }

    //退回
    @Override
    public void sendBack(String taskId){
        User user = getCurrUser();
        Task task = taskService.createTaskQuery()
                .taskId(taskId).singleResult();
        if(task == null){
            throw new IllegalArgumentException("任务不存在{" + taskId +"}");
        }

        if(task!= null) {
            if(task.getOwner() == null || !task.getOwner().equals(user.getUserId())){
                throw new ProcessIllegalAccessException("无法退回其他人占有的任务 当前用户为{"+ task.getOwner() +"}");
            }

            Map<String, Object> param = new HashMap<>();
            param.put("sendBack", SendBack.SEND_BACK.getType());
            taskService.complete(taskId, param);

            setProcessDataEndTime(taskId);

            if(processIsEnd(task.getProcessInstanceId())){
                return;//如退回后流程已结束，不做其他处理（废弃流程）
            }

            List<Task> tasks = taskService.createTaskQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .list();
            if(tasks == null || tasks.size() == 0 || tasks.size() > 1)
                throw new RuntimeException("流程设计问题, 退回后无新任务或启动了多个任务,请检查流程bpmn文件");
            Task newTask = tasks.get(0);

            List<HistoricTaskInstance> historicTaskInstanceList = historyService
                    .createHistoricTaskInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .taskDefinitionKey(newTask.getTaskDefinitionKey())
                    .list();

            Date latestHistoric = minDate;
            HistoricTaskInstance historicTask = null;//找到最近的历史节点(TaskDefinitionKey相同)
            for(HistoricTaskInstance h  : historicTaskInstanceList){
                if(h.getOwner()!= null || h.getAssignee()!= null){
                    if(h.getCreateTime().getTime() > latestHistoric.getTime()) {
                        latestHistoric = h.getCreateTime();
                        historicTask = h;
                    }
                }
            }

            //1.复制历史节点的处理人(退回至发起人)
            //2.复制最新的数据至appProcessInstanceData
            if(historicTask!= null){
                boolean updated = false;
                if (historicTask.getOwner() != null) {
                    updated = true;
                    newTask.setOwner(historicTask.getOwner());
                }
                if (historicTask.getAssignee() != null) {
                    updated = true;
                    newTask.setAssignee(historicTask.getAssignee());
                }
                if (updated) {
                    taskService.saveTask(newTask);
                    AppProcessInstanceData d = appProcessInstanceDataMapper.selectLastRecordByInstanceId(task.getProcessInstanceId());
                    d.setCreateTime(new Date());
                    d.setCreator(historicTask.getOwner());
                    d.setTaskId(newTask.getId());
                    d.setTaskName(newTask.getName());
                    d.setEndTime(null);
                    appProcessInstanceDataMapper.insert(d);
                }
            }
        }
    }

    private void setProcessDataEndTime(String taskId){
        AppProcessInstanceData data = appProcessInstanceDataMapper.selectByTaskId(taskId);
        if(data != null){
            data.setEndTime(new Date());
            appProcessInstanceDataMapper.updateByPrimaryKeyWithoutData(data);
        }
    }

    //查流程图
    @Override
    public void draw(String instanceId, OutputStream outputStream){
        ProcessEngineConfiguration conf = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = conf.getProcessDiagramGenerator();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        HistoricProcessInstance historyInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        if(historyInstance != null && historyInstance.getEndTime()!= null){
            writeToStream(new ByteArrayInputStream(endProcessImage.getBytes(StandardCharsets.UTF_8)), outputStream);
            return;
            //throw new IllegalArgumentException("流程已结束{" + instanceId + "}");
        }
        if(processInstance == null)
            throw new IllegalArgumentException("未找到流程实例{"+ instanceId +"}");

        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());

        List<String> activityIds = new ArrayList<>();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(instanceId)
                .list();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "jpg", activityIds, Collections.emptyList(),"宋体","宋体","宋体",conf.getClassLoader(),1.0, false);
        writeToStream(in, outputStream);
    }

    private void writeToStream(InputStream in, OutputStream outputStream){
        byte[] buf = new byte[1024];
        int len;
        try{
            while ((len = in.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
