package org.fran.demo.flowable.springboot.service.impl.process;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import liquibase.pro.packaged.D;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.fran.demo.flowable.springboot.dao.po.*;
import org.fran.demo.flowable.springboot.exceptions.ProcessIllegalAccessException;
import org.fran.demo.flowable.springboot.service.ProcessService;
import org.fran.demo.flowable.springboot.service.impl.loginuser.User;
import org.fran.demo.flowable.springboot.vo.ProcessEditVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProcessServiceImpl extends ProcessFlow {

    @Override
    public void startProcess(Long processDefinitionId){
        User user = getCurrUser();
        AppProcessDefinition r = appProcessDefinitionMapper.selectByPrimaryKey(processDefinitionId);
        if(r == null){
            throw new IllegalArgumentException("未找到流程,请检查processDefinitionId是否正确");
        }

        //初始化流程属性
        List<AppProcessDefinitionVariables> variables = appProcessDefinitionVariablesMapper.selectByProcessDefinitionId(r.getId());
        Map<String, Object> param = new HashMap<>();
        if(variables!= null && variables.size()> 0){
            for(AppProcessDefinitionVariables v : variables)
                param.put(v.getVariableKey(), v.getVariableValue());
        }

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .list();
        String deploymentId = null;
        int version = -1;//选择最新版本的
        for(int i =0; i < processDefinitions.size(); i++){
            ProcessDefinition pd = processDefinitions.get(i);
            if(pd.getKey().equals(r.getDeployId()) && pd.getVersion() > version){
                deploymentId = pd.getDeploymentId();
                version = pd.getVersion();
            }
        }
        if(deploymentId == null)
            throw new IllegalArgumentException("未找到流程{"+ r.getDeployId() +"},请检查bpmn文件是否正确存放");

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deploymentId)
                .singleResult();
        if(processDefinition == null){
            throw new IllegalArgumentException("未找到流程{"+ deploymentId +"},请检查bpmn文件是否正确存放");
        }

        //启动新的流程实例
        ProcessInstance instance = runtimeService.startProcessInstanceById(
                processDefinition.getId(), param);
        Task task = taskService.createTaskQuery()
                .processInstanceId(instance.getId())
                .singleResult();
        if(task!= null){
            task.setOwner(user.getUserId());
            taskService.saveTask(task);

            try{
                //保存流程数据
                AppProcessInstanceData taskData = new AppProcessInstanceData();
                taskData.setTaskId(task.getId());
                taskData.setCreator(user.getUserId());
                taskData.setInstanceId(task.getProcessInstanceId());
                taskData.setCreateTime(new Date());
                taskData.setCreator(user.getUserId());
                taskData.setTaskName(task.getName());
                appProcessInstanceDataMapper.insert(taskData);

                //保存search和instance的关联
                AppProcessSearchKeys searchKeys = new AppProcessSearchKeys();
                appProcessSearchKeysMapper.insert(searchKeys);
                Long searchKeysId = searchKeys.getId();
                if(searchKeysId == null)
                    throw new RuntimeException("保存AppProcessSearchKeys异常");

                AppProcessInstanceSearch instanceSearch = new AppProcessInstanceSearch();
                instanceSearch.setSearchId(searchKeysId);
                instanceSearch.setProcessInstanceId(task.getProcessInstanceId());
                appProcessInstanceSearchMapper.insert(instanceSearch);
            }catch (Exception e){
                throw new RuntimeException("保存流程数据异常{AppProcessInstanceSearch、AppProcessSearchKeys、AppProcessInstanceData}", e);
            }
        }
    }

    private void saveSearchKeys(String instanceId, Map<String, Object> variables){
        List<AppProcessInstanceSearch> instanceSearch = appProcessInstanceSearchMapper.selectByInstanceId(instanceId);
        if(instanceSearch == null || instanceSearch.size() == 0){
            throw new RuntimeException("保存流程搜索数据异常");
        }else{
            AppProcessInstanceSearch lastData = instanceSearch.get(0);
            AppProcessSearchKeys searchKeys = appProcessSearchKeysMapper.selectByPrimaryKey(lastData.getSearchId());
            if(searchKeys == null)
                throw new RuntimeException("保存流程搜索数据异常");
            else{
                if(variables!= null && variables.size()>0){
                    searchKeys.setKey1(getSearchKey(variables.get("k1")));
                    searchKeys.setKey2(getSearchKey(variables.get("k2")));
                    searchKeys.setKey3(getSearchKey(variables.get("k3")));
                    searchKeys.setKey4(getSearchKey(variables.get("k4")));
                    searchKeys.setKey5(getSearchKey(variables.get("k5")));

                    appProcessSearchKeysMapper.updateByPrimaryKey(searchKeys);
                }
            }
        }
    }

    private String getSearchKey(Object key){
        if(key == null)
            return null;
        else
            return key.toString();
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void save(String taskId, Map<String, Object> variables){
        User user = getCurrUser();
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        if(task == null)
            throw new IllegalArgumentException("任务不存在{" + taskId +"}");
        if(task.getOwner() == null) {
            throw new ProcessIllegalAccessException("任务未被占有,保存失败");
        }else{
            if(!task.getOwner().equals(user.getUserId())){
                throw new IllegalArgumentException("任务已被其他审核人占有,保存失败 uid{"+ user.getUserId() +"}  taskOwner{"+ task.getOwner() +"}");
            }
        }

        //保存任务搜索key
        saveSearchKeys(task.getProcessInstanceId(), variables);

        //保存or更新 variables
        try {
            String json = objectMapper.writeValueAsString(variables);
            AppProcessInstanceData taskData = appProcessInstanceDataMapper.
                    selectByTaskId(taskId);
            if(taskData == null){
                taskData = new AppProcessInstanceData();
                taskData.setTaskId(taskId);
                taskData.setInstanceId(task.getProcessInstanceId());
                taskData.setCreateTime(new Date());
                taskData.setCreator(user.getUserId());
                taskData.setTaskName(task.getName());
                appProcessInstanceDataMapper.insert(taskData);
            }else{
                taskData.setData(json.getBytes(StandardCharsets.UTF_8));
                appProcessInstanceDataMapper.updateByPrimaryKey(taskData);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProcessEditVO edit(String taskId){
        User user = getCurrUser();
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        if(task == null)
            throw new IllegalArgumentException("任务不存在{" + taskId +"}");
        if(task.getOwner() == null) {
            if(checkLegalOwn(user, taskId)){
                task.setOwner(user.getUserId() + "");
                taskService.saveTask(task);
            }else
                throw new IllegalArgumentException("任务无权占用,占有失败 uid{"+ user.getUserId() +"}");

        }else{
            if(!task.getOwner().equals(user.getUserId())){
                throw new IllegalArgumentException("任务已被其他审核人占有,占有失败 uid{"+ user.getUserId() +"}  taskOwner{"+ task.getOwner() +"}");
            }
        }
        ProcessEditVO processEditVO = new ProcessEditVO(
                task.getId(),
                task.getName(),
                task.getProcessInstanceId(),
                null
        );
        AppProcessInstanceData data = appProcessInstanceDataMapper.selectByTaskId(taskId);
        if(data == null){
            return processEditVO;
        }else{
            byte[] bytes = data.getData();
            try {
                if(bytes == null || bytes.length == 0){
                    return processEditVO;
                }else{
                    if(data.getCreator() == null){
                        data.setCreator(user.getUserId());
                        data.setCreateTime(new Date());
                        appProcessInstanceDataMapper.updateByPrimaryKeyWithoutData(data);
                    }

                    Map<String, Object> jsonData = objectMapper.readValue(bytes, new TypeReference<Map<String, Object>>() {
                    });
                    processEditVO.setData(jsonData);
                    return processEditVO;
                }
            } catch (IOException e) {
                throw new RuntimeException("解析AppProcessInstanceData异常", e);
            }
        }
    }

    @Override
    public List<HistoricTaskInstance> historic(String instanceId){

        List<HistoricTaskInstance> historyList = historyService
                .createHistoricTaskInstanceQuery()
                .processInstanceId(instanceId)
                .orderByHistoricTaskInstanceStartTime().asc()
                .list();

        return historyList;

    }
}
