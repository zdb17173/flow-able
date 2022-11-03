package org.fran.demo.flowable.engine.demo.production;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CGTNProcess3 {

    static RuntimeService runtimeService;
    static TaskService taskService;
    static HistoryService historyService;
    static RepositoryService repositoryService;

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("production/cgtn-3.bpmn20.xml")
                .deploy();

        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        historyService = processEngine.getHistoryService();
        repositoryService = processEngine.getRepositoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        Map<String, Object> param = new HashMap<>();
        param.put("node1", "n11,n12,n13");
        param.put("node2", "n21,n22");
        param.put("node3", "n31,n32,n33,n34");
        param.put("node4", "n41,n42");

        ProcessInstance instance = runtimeService.startProcessInstanceById(
                processDefinition.getId(), param);

        //第一个节点
        String curUser = "n11";
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks, false, new String[]{"a1", "a2", "a3"});

        //第二个节点(因为上一个节点设置了候选人a1 所以原有的n21查不到数据)
        curUser = "n21";//n21
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks);

        //第二个节点
        curUser = "a1";//因为上一个节点设置了候选人a1 所以可以查到数据
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks);

        //第三个节点
        curUser = "n31";
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        back(tasks, 2 ,false);
//        submit(tasks, curUser);


        //第二个节点
        curUser = "a2";//因为上一个节点设置了候选人a1 所以可以查到数据
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks);


        //第三个节点
        curUser = "n31";//因为上一个节点设置了候选人a1 所以可以查到数据
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks);


        //第四个节点
        curUser = "n41";
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        edit(tasks, curUser);
        submit(tasks);

    }

    public static String getNextNode(String curNodeKey){
        if(curNodeKey == null)
            return null;
        else{
            int nodeNum = Integer.valueOf(curNodeKey.replaceAll("node", ""));
            return "node" + (nodeNum + 1);
        }
    }


    public static void edit(List<Task> tasks, String owner){
        if(tasks.size()>0) {
            Task task = tasks.get(0);
            task.setOwner(owner);
            taskService.saveTask(task);
        }
    }

    public static void submit(List<Task> tasks){
        submit(tasks, false, null);
    }

    public static void submit(List<Task> tasks, boolean end){
        submit(tasks, end, null);
    }

    public static void submit(List<Task> tasks, boolean end, String... nextNodeCandidate){
        String instanceId = null;
        System.out.println("任务数量:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务:" + task.getName());
            instanceId = task.getProcessInstanceId();
            Map<String, Object> param1 = new HashMap<>();

            if(!end)
                param1.put("sendBack", "0");
            else
                param1.put("sendBack", "-1");

            //设置下一级候选人
            if(nextNodeCandidate != null && nextNodeCandidate.length > 0){
                String nextNode = getNextNode(task.getTaskDefinitionKey());
                String nextNodeCanidateStr = "";
                for(String s : nextNodeCandidate)
                    nextNodeCanidateStr += nextNodeCanidateStr.equals("")? s : ("," + s);
                param1.put(nextNode, nextNodeCanidateStr);
            }

            taskService.complete(task.getId(), param1);

            ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .singleResult();
            if(instance!= null) {
                System.out.println("流程是否结束{" + instance.isEnded() + "}");
            }else{
                System.out.println("流程结束");

                List<HistoricProcessInstance> history = historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(task.getProcessInstanceId())
                        .list();
                for(HistoricProcessInstance historicProcessInstance : history) {
                    System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + " " + historicProcessInstance.getEndTime());
                    Map<String, Object> variables = historicProcessInstance.getProcessVariables();

                    List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery()
                            .processInstanceId(historicProcessInstance.getSuperProcessInstanceId())
                            .list();
                    for(HistoricTaskInstance t : historicTasks){
                        System.out.println("{ task:" + t.getName() +"} { user:"+ t.getOwner() + "}  { endTime:" + t.getEndTime() + "}");
                    }

                }
            }
        }
    }

    public static void back(List<Task> tt, int node, boolean backToPreviousOwner){
        if(tt.size()>0) {
            Task task = tt.get(0);

            Map<String, Object> param = new HashMap<>();
            param.put("sendBack", node);
            taskService.complete(task.getId(), param);

            List<Task> tasks = taskService.createTaskQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .list();
            if(tasks == null || tasks.size() == 0 || tasks.size() > 1)
                throw new RuntimeException("流程设计问题, 退回后无新任务或启动了多个任务,请检查流程bpmn文件");
            Task newTask = tasks.get(0);
            if(!backToPreviousOwner){//如不需要退回之前的owner 直接返回
                //TODO: 将当前task的data 复制给 newTask的data
                return;
            }

            List<HistoricTaskInstance> historicTaskInstanceList = historyService
                    .createHistoricTaskInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .taskDefinitionKey(newTask.getTaskDefinitionKey())
                    .list();

            Date latestHistoric = new Date(532281600000l);;
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
//                    AppProcessInstanceData d = appProcessInstanceDataMapper.selectLastRecordByInstanceId(task.getProcessInstanceId());
//                    d.setCreateTime(new Date());
//                    d.setCreator(historicTask.getOwner());
//                    d.setTaskId(newTask.getId());
//                    d.setTaskName(newTask.getName());
//                    d.setEndTime(null);
//                    appProcessInstanceDataMapper.insert(d);
                    //TODO： 将当前task的data 复制给 newTask的data
                }

            }
        }
    }

    //判断流程是否已经结束
    protected boolean processIsEnd(String instanceId){
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        if(instance == null || instance.isEnded()){
            return true;
        }else
            return false;
    }
}
