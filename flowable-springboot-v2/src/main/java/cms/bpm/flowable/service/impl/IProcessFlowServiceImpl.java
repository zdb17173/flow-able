package cms.bpm.flowable.service.impl;

import cms.bpm.flowable.dto.BpmnModelDto;
import cms.bpm.flowable.dto.FlowDto;
import cms.bpm.flowable.dto.FlowResult;
import cms.bpm.flowable.exceptions.ProcessException;
import cms.bpm.flowable.exceptions.ProcessIllegalArgumentException;
import cms.bpm.flowable.service.IProcessDefinitionService;
import cms.bpm.flowable.service.IProcessFlowService;
import cms.bpm.flowable.service.IProcessUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/11/2
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IProcessFlowServiceImpl extends ProcessCommon implements IProcessFlowService {

    @Override
    public void save(FlowDto taskDto){
        if(taskDto == null || StringUtils.isEmpty(taskDto.getTaskId()))
            throw new ProcessIllegalArgumentException("流程流转FlowDto参数不可为空，taskId不可为空");

        IProcessUserService.ProcessUser user = getCurrUser();//未登录会抛异常
        Task task = taskService.createTaskQuery()
                .taskId(taskDto.getTaskId())
                .includeProcessVariables()
                .singleResult();
        if(task == null)
            throw new ProcessIllegalArgumentException("任务不存在{" + taskDto.getTaskId() +"}");

        Map<String, Object> param = task.getProcessVariables();
        param.putAll(taskDto.getVariables());

        taskService.setVariables(
                task.getId(),
                param);
    }

    @Override
    public Map<String, Object> edit(String taskId) {
        if(StringUtils.isEmpty(taskId))
            throw new ProcessIllegalArgumentException("流程占有taskId不可为空");

        IProcessUserService.ProcessUser user = getCurrUser();//未登录会抛异常
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .includeProcessVariables()
                .singleResult();
        if (task == null)
            throw new ProcessException("任务已审核,请刷新列表{" + taskId + "}");
        if (task.getOwner() == null) {
            if (checkEditIsLegal(user, taskId)) {
                task.setOwner(user.getId());
                taskService.saveTask(task);
            } else
                throw new ProcessException("任务无权占用,占有失败 uid{" + user.getId() + "}");
        } else {
            if (!task.getOwner().equals(user.getId())) {
                throw new ProcessException("任务已被其他审核人占有,占有失败,请刷新列表 uid{" + user.getId() + "}  taskOwner{" + task.getOwner() + "}");
            }
        }

        Map<String, Object> variables = task.getProcessVariables();
        return variables;
    }

    @Override
    public FlowResult submit(FlowDto taskDto) {
        if(taskDto == null || StringUtils.isEmpty(taskDto.getTaskId()))
            throw new ProcessIllegalArgumentException("流程流转FlowDto参数不可为空，taskId不可为空");

        IProcessUserService.ProcessUser user = getCurrUser();//未登录会抛异常
        Task task = taskService.createTaskQuery()
                .taskId(taskDto.getTaskId())
                .includeProcessVariables()
                .singleResult();
        if(task == null)
            throw new ProcessIllegalArgumentException("任务不存在{" + taskDto.getTaskId() +"}");

        edit(taskDto.getTaskId());//已被占有或无法占有会抛异常

        Map<String, Object> param = task.getProcessVariables();
        param.put("flow", FlowStatus.FORWARD.getType());

        if(taskDto.getVariables()!= null)
            param.putAll(taskDto.getVariables());

        taskService.setVariables(
                task.getId(),
                param);

        taskService.complete(task.getId(), param);//流程向下流转

        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();

        if(instance == null || instance.isEnded()){
            HistoricProcessInstance historyInstance = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .singleResult();
            return new FlowResult(
                    task.getProcessInstanceId(),
                    historyInstance == null ? "" : historyInstance.getBusinessKey(),
                    true
            );
        }else{
            return new FlowResult(
                    task.getProcessInstanceId(),
                    instance.getBusinessKey(),
                    instance.isEnded()
            );
        }
    }

    @Override
    public void sendBack(String taskId, String targetNodeKey) {
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        if(task == null)
            throw new ProcessIllegalArgumentException("未找到对应任务");
        edit(taskId);//已被占有或无法占有会抛异常
        jump(targetNodeKey, task);
    }

    @Override
    public List<BpmnModelDto.BpmnUserTaskDto> getBeforeUserTasks(String taskId) {
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        String processDefinitionId = task.getProcessDefinitionId();
        BpmnModelDto bpmnModel = processDefinitionService.getProcessDefinitionById(task.getTenantId(), processDefinitionId);
        if(bpmnModel!= null){
            List<BpmnModelDto.BpmnUserTaskDto> preNodes = new ArrayList<>();
            for(BpmnModelDto.BpmnUserTaskDto userTask : bpmnModel.getUserTasks()){
                if(userTask.getId().equals(task.getTaskDefinitionKey()))
                    return preNodes;
                else
                    preNodes.add(userTask);
            }
        }
        return null;
    }

    private void jump(String jumpTo, Task task){
        runtimeService.createChangeActivityStateBuilder()
                .processInstanceId(task.getProcessInstanceId())
                .moveActivityIdTo(task.getTaskDefinitionKey(), jumpTo)
                .changeState();
    }

    enum FlowStatus{
        FORWARD(0),TO_END(-1);
        FlowStatus(int type){
            this.type = type;
        }
        int type;
        int getType(){
            return type;
        }
    }

    @Resource
    IProcessDefinitionService processDefinitionService;
}
