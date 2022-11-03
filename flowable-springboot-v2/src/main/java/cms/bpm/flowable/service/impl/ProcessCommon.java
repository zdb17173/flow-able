package cms.bpm.flowable.service.impl;

import cms.bpm.flowable.exceptions.ProcessIllegalAccessException;
import cms.bpm.flowable.service.IProcessUserService;
import org.flowable.engine.*;
import org.flowable.task.api.Task;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiushi
 * @date 2022/11/2
 */
public abstract class ProcessCommon extends ProcessVariableConstant{
    @Resource
    ProcessEngine processEngine;
    @Resource
    RuntimeService runtimeService;
    @Resource
    TaskService taskService;
    @Resource
    HistoryService historyService;
    @Resource
    RepositoryService repositoryService;
    @Resource
    IProcessUserService processUserService;

    //获取当前用户
    protected IProcessUserService.ProcessUser getCurrUser(){
        IProcessUserService.ProcessUser user = processUserService.getCurrentUser();
        if(user == null || user.getId() == null)
            throw new ProcessIllegalAccessException("未获得登录用户信息");
        return user;
    }

    //获取当前用户角色（如无角色则把uid作为唯一的角色）
    protected List<String> getUserRoleList(){
        IProcessUserService.ProcessUser user = getCurrUser();
        List<String> strRoleList = new ArrayList<>();
        if(user == null)
            return strRoleList;
        List<IProcessUserService.ProcessRole> roles = user.getRoles();
        if(roles == null || roles.size() == 0)
            strRoleList.add(user.getId());
        else
            roles.stream().forEach( role -> strRoleList.add(role.getRoleName()));
        return strRoleList;
    }

    //校验用户是否有权占用任务
    public boolean checkEditIsLegal(IProcessUserService.ProcessUser user, String taskId){
        if(user == null)
            return false;

        List<String> strRoleList = new ArrayList<>();
        List<IProcessUserService.ProcessRole> roles = user.getRoles();
        if(roles == null || roles.size() == 0)
            strRoleList.add(user.getId());
        else
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

    //判断流程是否已经结束
    protected boolean processIsEnd(String instanceId){
        org.flowable.engine.runtime.ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        if(instance == null || instance.isEnded()){
            return true;
        }else
            return false;
    }
}