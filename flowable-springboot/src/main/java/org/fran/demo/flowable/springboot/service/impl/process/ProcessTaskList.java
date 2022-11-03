package org.fran.demo.flowable.springboot.service.impl.process;

import org.flowable.task.api.Task;
import org.fran.demo.flowable.springboot.dao.po.AppProcessSearchKeys;
import org.fran.demo.flowable.springboot.service.ProcessService;
import org.fran.demo.flowable.springboot.service.impl.loginuser.Role;
import org.fran.demo.flowable.springboot.service.impl.loginuser.User;
import org.fran.demo.flowable.springboot.vo.TaskVO;

import java.util.ArrayList;
import java.util.List;

// 任务列表查询 任务校验等
public abstract class ProcessTaskList extends ProcessCommon implements ProcessService {

    //校验用户是否有权占用任务
    public boolean checkLegalOwn(User user, String taskId){
        if(user == null || user.getRoles() == null || user.getRoles().size() == 0 )
            return false;

        List<String> strRoleList = new ArrayList<>();
        List<Role> roles = user.getRoles();
        roles.stream().forEach( role -> strRoleList.add(role.getRoleName()));

        Task task = taskService.createTaskQuery()
                .taskCandidateGroupIn(strRoleList)
                .taskId(taskId)
                .singleResult();

        if(task == null)
            return false;
        else
            return true;
    }

    @Override
    public List<TaskVO> tasks(TaskListType taskListType, int start, int max){
        User user = getCurrUser();
        List<Role> roles = user.getRoles();
        List<String> strRoleList = new ArrayList<>();
        if(roles == null || roles.size() == 0)
            return new ArrayList<>();
        else
            roles.stream().forEach( role -> strRoleList.add(role.getRoleName()));

        List<TaskVO> res = new ArrayList<>();
        if(taskListType == TaskListType.ALL || taskListType == TaskListType.INPOOL){
            List<Task> tasks = taskService.createTaskQuery()
                    .taskCandidateGroupIn(strRoleList)
                    .listPage(start, max);
            List<String> instanceIds = new ArrayList<>();
            for(Task t : tasks)
                if(t.getOwner() == null)
                    instanceIds.add(t.getProcessInstanceId());

            List<AppProcessSearchKeys> searchKeys = new ArrayList<>();
            if(instanceIds.size() > 0 )
                searchKeys = appProcessSearchKeysMapper.selectByInstanceId(instanceIds);

            for(Task t : tasks){
                if(t.getOwner() == null) {
                    TaskVO taskVO = new TaskVO(t.getName(), t.getProcessInstanceId(), t.getId(), t.getOwner());
                    for(AppProcessSearchKeys k : searchKeys){
                        if(k.getInstanceId().equals(t.getProcessInstanceId())){
                            taskVO.setKey1(k.getKey1());
                            taskVO.setKey2(k.getKey2());
                            taskVO.setKey3(k.getKey3());
                            taskVO.setKey4(k.getKey4());
                            taskVO.setKey5(k.getKey5());
                        }
                    }
                    res.add(taskVO);
                }
            }
        }

        if(taskListType == TaskListType.ALL || taskListType == TaskListType.OWNED){
            List<Task> ownTasks = taskService.createTaskQuery()
                    .taskOwner(user.getUserId())
                    .listPage(start, max);
            List<String> instanceIds = new ArrayList<>();
            for(Task t : ownTasks)
                instanceIds.add(t.getProcessInstanceId());

            List<AppProcessSearchKeys> searchKeys = new ArrayList<>();
            if(instanceIds.size() > 0 )
                searchKeys = appProcessSearchKeysMapper.selectByInstanceId(instanceIds);

            for(Task t : ownTasks){
                TaskVO taskVO = new TaskVO(t.getName(), t.getProcessInstanceId(), t.getId(), t.getOwner());
                for(AppProcessSearchKeys k : searchKeys){
                    if(k.getInstanceId().equals(t.getProcessInstanceId())){
                        taskVO.setKey1(k.getKey1());
                        taskVO.setKey2(k.getKey2());
                        taskVO.setKey3(k.getKey3());
                        taskVO.setKey4(k.getKey4());
                        taskVO.setKey5(k.getKey5());
                    }
                }
                res.add(taskVO);
            }
        }

        return res;
    }
}
