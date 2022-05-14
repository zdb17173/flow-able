package org.fran.demo.flowable.engine.demo.gateway;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.DelegationState;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.Iterator;
import java.util.List;

/**
 * @author fran
 * @Description 网关的退回测试
 * @Date 2022/5/8 21:20
 */
public class GatewayTest2 {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        // start --> user1 --> user2 -- gateway --{back = 1}-->end
        //             |                   |
        //             <---{back = 2}<------
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("gateway/gateway-test-2.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        ProcessInstance instance = runtimeService.startProcessInstanceById(processDefinition.getId());

//        routeSuccess(taskService);//正常路线
        routeBack(taskService, historyService);//退回路线

        queryHistory(historyService);
    }


    /*public static void back(HistoryService historyService, RuntimeService runtimeService){
        List<HistoricTaskInstance> historicTaskInstanceList = historyService.createHistoricTaskInstanceQuery().processInstanceId(task.getProcessInstanceId()).orderByHistoricTaskInstanceStartTime().asc().list();
        Iterator<HistoricTaskInstance> it = historicTaskInstanceList.iterator();
        //循环节点，获取当前节点的上一节点的key
        String tkey = "";
        while(it.hasNext())    {
            HistoricTaskInstance his = it.next();
            if (!taskkey.equals(his.getTaskDefinitionKey())){
                tkey = his.getTaskDefinitionKey();
            }
        }

        //回退（节点跳转）
        runtimeService.createChangeActivityStateBuilder()
                .processInstanceId(piid)
                .moveActivityIdTo(taskkey, tkey)
                .changeState();
    }*/


    public static void routeBack(TaskService taskService, HistoryService historyService){
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user1").list();
        System.out.println("任务1:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务1:" + task.getId());
            taskService.claim(task.getId(), "fran1");//签收，签收会将fran设置给Assignee
            taskService.setOwner(task.getId(), "fran1");
            taskService.complete(task.getId());
        }

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user2").list();
        System.out.println("任务2:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务2:" + task.getId());
            taskService.setVariable(task.getId(), "back", 1);
            taskService.claim(task.getId(), "fran2");//签收，签收会将fran设置给Assignee
            taskService.setOwner(task.getId(), "fran2");

            taskService.complete(task.getId());


            //退回逻辑（找到历史task，将key相同的进行复制）
            tasks = taskService.createTaskQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .list();
            List<HistoricTaskInstance> historicTaskInstanceList = historyService.
                    createHistoricTaskInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId()).orderByHistoricTaskInstanceStartTime().asc().list();
            if(tasks.size() > 0 && historicTaskInstanceList.size() > 0){
                for(Task t : tasks){
                    for(HistoricTaskInstance tt : historicTaskInstanceList){
                        if(tt.getTaskDefinitionKey().equals(t.getTaskDefinitionKey())){
                            boolean updated = false;
                            if(tt.getOwner()!= null) {
                                updated = true;
                                t.setOwner(tt.getOwner());
                            }
                            if(tt.getAssignee()!= null) {
                                updated = true;
                                t.setAssignee(tt.getAssignee());
                            }
                            if(updated)
                                taskService.saveTask(t);
                        }
                    }
                }
            }
            //退回结束

        }

        //委派任务给zzz
        tasks = taskService.createTaskQuery()
                .taskAssignee("fran1")
                .list();
        System.out.println("任务3:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务2:" + task.getId());

            taskService.delegateTask(task.getId(), "zzz");
        }

        //zzz查看任务 委派的任务taskId不变
        tasks = taskService.createTaskQuery()
                .taskAssignee("zzz")
                .list();
        System.out.println("任务4:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务4:" + task.getId());
            taskService.resolveTask(task.getId());
//            taskService.complete(task.getId()); 委派的任务不能complete
        }

        //委派后的任务转会原人员，fran1
        tasks = taskService.createTaskQuery()
                .taskAssignee("fran1")
                .list();
        System.out.println("任务5:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
//            task.getDelegationState().compareTo(DelegationState.RESOLVED)
            System.out.println("委派任务状态5:" + task.getId() + task.getDelegationState());
            taskService.complete(task.getId());


            //重新打开逻辑（找到历史task，将key相同的进行复制）
            tasks = taskService.createTaskQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .list();
            List<HistoricTaskInstance> historicTaskInstanceList = historyService.
                    createHistoricTaskInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId()).orderByHistoricTaskInstanceStartTime().asc().list();
            if(tasks.size() > 0 && historicTaskInstanceList.size() > 0){
                for(Task t : tasks){
                    for(HistoricTaskInstance tt : historicTaskInstanceList){
                        if(tt.getTaskDefinitionKey().equals(t.getTaskDefinitionKey())){
                            boolean updated = false;
                            if(tt.getOwner()!= null) {
                                updated = true;
                                t.setOwner(tt.getOwner());
                            }
                            if(tt.getAssignee()!= null) {
                                updated = true;
                                t.setAssignee(tt.getAssignee());
                            }
                            if(updated)
                                taskService.saveTask(t);
                        }
                    }
                }
            }
            //重新打开逻辑

        }


        //重新打开的任务用fran2可以搜到
        tasks = taskService.createTaskQuery()
//                .taskCandidateGroup("user2")//用user2搜不到，因为重新打开自动使用上一次该任务的签收人签了
                .taskAssignee("fran2")
                .list();
        System.out.println("任务6:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            System.out.println("任务6:" + task.getId());
            taskService.setVariable(task.getId(), "back", 2);
            taskService.complete(task.getId());
        }

    }

    //正常路线
    public static void routeSuccess(TaskService taskService){
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user1").list();
        System.out.println("任务1:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            taskService.claim(task.getId(), "fran1");//签收，签收会将fran设置给Assignee
            taskService.complete(task.getId());
        }


        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user2").list();
        System.out.println("任务2:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);

            taskService.setVariable(task.getId(), "back", 2);

            taskService.complete(task.getId());
        }
    }


    public static void queryHistory(HistoryService historyService){
        //启动的两个任务都完成
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();
        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances)
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + historicProcessInstance.getEndTime());

    }
}
