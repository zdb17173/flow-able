package org.fran.demo.flowable.engine.demo.event;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description 测试none中间事件 触发EexecutionListener
 * @Date 2022/5/7 0:25
 */
public class IntermediateEventTest1 {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();


        // start --> 用户任务1 --> 中间事件(调用ExecutionListener1) --> 用户2 --> end

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("event/event-test-intermediate-1.bpmn20.xml")
//                .addClasspathResource("event/event-test-error-2.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        Map<String, Object> param = new HashMap<>();
        param.put("employee", "hahahah");
        runtimeService.startProcessInstanceByKey(processDefinition.getKey());//启动流程1

        System.out.println("任务1开始" + new Date());
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateUser("user1").list();
        if(tasks.size()>0){
            Task task = tasks.get(0);
            taskService.complete(task.getId());
        }

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务2开始" + new Date());
        tasks = taskService.createTaskQuery()
                .taskCandidateUser("user2").list();
        if(tasks.size()>0){
            Task task = tasks.get(0);
            taskService.complete(task.getId());
        }


        //完成了一个
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();
        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances)
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + historicProcessInstance.getEndTime());

    }
}
