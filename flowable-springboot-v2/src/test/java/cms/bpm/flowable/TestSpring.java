package cms.bpm.flowable;

import cms.bpm.flowable.dto.*;
import cms.bpm.flowable.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author qiushi
 * @date 2022/11/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {FlowableApp.class})
public class TestSpring {

    @Test
    public void baseTest(){

        //查找流程
        BpmnModelDto process = processDefinitionService
                .listProcess("default").get(0);
        System.out.println("找到流程<"
                + "pdId:" + process.getProcessDefinitionId() + " "
                + "processId:" + process.getProcessId() + " "
                + "processName:" + process.getProcessName() + ">"
        );


        //启动流程
        processUserService.setCurrentUser(user1);//当前登录用户为user1
        ProcessInstanceDto instance = processInstanceService.startProcess(
                new CreateProcessDto(process.getProcessDefinitionId())
                        .withVariables("node1", "1,2")//第一个节点，审批人 =[1,2] 此处和用户的role角色关联
                        .withVariables("node2", "2")//第二个节点，审批人 = [2] 此处和用户的role角色关联
                        .withVariables("headline", "测试流程" + new Date())
        );
        System.out.println("流程启动完成：" + instance.getInstanceId() + " 启动时间：" + instance.getStartTime());


        //查找任务并提交
        FlowResult submitRes;
        List<TaskDto> tasks = processTaskQueryService
                .inPoolAndOwned(TaskQueryDto.build());
        if(tasks.size() > 0){
            TaskDto task = tasks.get(0);
            System.out.println("找到任务 taskId:" + task.getTaskId() + " taskName:" + task.getTaskName() + " var:" + task.getVariables());
            submitRes = processFlowService.submit(
                    new FlowDto(task.getTaskId(), null)
                            .withVariables("url", "www.baidu.com")
                            .withVariables("boss", "Woo")
                            .withVariables("date", "2022-11-11")
            );
            System.out.println("提交结束1" + submitRes.isEnd());
        }


        //查找任务并退回node1
        processUserService.setCurrentUser(user2);//当前登录用户为user2
        tasks = processTaskQueryService
                .inPoolAndOwned(TaskQueryDto.build());
        if(tasks.size() > 0){
            TaskDto task = tasks.get(0);
            //查看以往的节点有哪些
            List<BpmnModelDto.BpmnUserTaskDto> preNodes = processFlowService.getBeforeUserTasks(task.getTaskId());

            processFlowService.sendBack(task.getTaskId(), preNodes.get(0).getId());
            System.out.println("退回第一个节点  preNodes["+ preNodes +"]");
        }


        //切换至用户1查找任务并提交
        processUserService.setCurrentUser(user1);//当前登录用户为user1
        tasks = processTaskQueryService
                .inPoolAndOwned(TaskQueryDto.build());
        if(tasks.size() > 0){
            TaskDto task = tasks.get(0);
            System.out.println("找到任务 taskId:" + task.getTaskId() + " taskName:" + task.getTaskName() + " var:" + task.getVariables());
            submitRes = processFlowService.submit(
                    new FlowDto(task.getTaskId(), null)
            );
            System.out.println("提交结束1" + submitRes.isEnd());
        }


        //切换至用户2查找任务并提交 流程结束
        processUserService.setCurrentUser(user2);//当前登录用户为user2
        tasks = processTaskQueryService
                .inPoolAndOwned(TaskQueryDto.build());
        if(tasks.size() > 0){
            TaskDto task = tasks.get(0);
            System.out.println("找到任务 taskId:" + task.getTaskId() + " taskName:" + task.getTaskName() + " var:" + task.getVariables());
            submitRes = processFlowService.submit(
                    new FlowDto(task.getTaskId(), null)
            );
            System.out.println("提交结束2" + submitRes.isEnd());
        }


    }

    //虚拟的用户1 没有设置角色，默认以用户id作为角色，流程引擎根据角色判断是否有权限处理任务
    static IProcessUserService.ProcessUser user1
            = new IProcessUserService.ProcessUser("1", "default", "editor", null);
    //虚拟的用户2 没有设置角色，默认以用户id作为角色，流程引擎根据角色判断是否有权限处理任务
    static IProcessUserService.ProcessUser user2
            = new IProcessUserService.ProcessUser("2", "default", "copyeditor", null);

    @Resource
    IProcessUserService processUserService;
    @Resource
    IProcessDefinitionService processDefinitionService;
    @Resource
    IProcessInstanceService processInstanceService;
    @Resource
    IProcessFlowService processFlowService;
    @Resource
    IProcessTaskQueryService processTaskQueryService;
}
