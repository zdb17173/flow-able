package cms.bpm.flowable.service.impl;

import cms.bpm.flowable.dto.TaskDto;
import cms.bpm.flowable.dto.TaskQueryDto;
import cms.bpm.flowable.service.IProcessTaskQueryService;
import cms.bpm.flowable.service.IProcessUserService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/11/2
 */
@Service
@Slf4j
public class ProcessTaskQueryServiceImpl extends ProcessCommon implements IProcessTaskQueryService {

    @Override
    public List<TaskDto> myTasks(TaskQueryDto taskQueryDto) {
        List<TaskDto> res = tasks(taskQueryDto, TaskListType.OWNED);
        return res;
    }

    @Override
    public List<TaskDto> inPoolTasks(TaskQueryDto taskQueryDto) {
        List<TaskDto> res = tasks(taskQueryDto, TaskListType.INPOOL);
        return res;
    }

    @Override
    public List<TaskDto> inPoolAndOwned(TaskQueryDto taskQueryDto) {
        List<TaskDto> res = tasks(taskQueryDto, TaskListType.ALL);
        return res;
    }

    public List<TaskDto> tasks(TaskQueryDto taskQueryDto, TaskListType taskListType){
        IProcessUserService.ProcessUser user = getCurrUser();
        String tenantId = user.getTenant();
        List<String> strRoleList = getUserRoleList();

        List<TaskDto> taskDtoList = new ArrayList<>();
        if(taskListType == TaskListType.ALL || taskListType == TaskListType.OWNED){
            TaskQuery taskQuery = taskService.createTaskQuery()
                    .taskOwner(user.getId())
                    .taskTenantId(tenantId)
                    .includeProcessVariables();

            taskQuery = initVariableQuery(taskQuery, taskQueryDto.getVariables());

            List<Task> tasks = taskQuery.listPage(
                    taskQueryDto.getCurPage() * taskQueryDto.getPageSize(),
                    taskQueryDto.getPageSize());
            tasks.forEach( t -> taskDtoList.add(taskToDto(t)));
        }

        if(taskListType == TaskListType.ALL || taskListType == TaskListType.INPOOL){
            TaskQuery taskQuery = taskService.createTaskQuery()
                    .taskCandidateGroupIn(strRoleList)
                    .taskTenantId(tenantId)
                    .includeProcessVariables();

            taskQuery = initVariableQuery(taskQuery, taskQueryDto.getVariables());

            List<Task> tasks = taskQuery.listPage(
                    taskQueryDto.getCurPage() * taskQueryDto.getPageSize(),
                    taskQueryDto.getPageSize());
            tasks.forEach( t -> taskDtoList.add(taskToDto(t)));
        }

        return taskDtoList;
    }

    private TaskQuery initVariableQuery(TaskQuery taskQuery, Map<String, String> varEq){
        if(varEq!= null && varEq.size() > 0){
            for(String key : varEq.keySet()){
                taskQuery = taskQuery.processVariableValueEquals(key, varEq.get(key));
            }
        }
        return taskQuery;
    }

    private TaskDto taskToDto(Task task){
        TaskDto dto = new TaskDto();
        dto.setOwner(task.getOwner());
        dto.setInstanceId(task.getProcessInstanceId());
        dto.setTaskId(task.getId());
        dto.setTaskCreateDate(task.getCreateTime());
        dto.setVariables(task.getProcessVariables());
        dto.setTaskName(task.getName());
        return dto;
    }
}
