package org.fran.demo.flowable.engine.demo.event;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description signal边界事件测试
 * @Date 2022/5/5 18:44
 */
public class BoundaryEventTest1 {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        //部署了两个signalEvent 都订阅了signal01这个信号，当发送signal01信号时，会同时启动两个流程
        //流程  start --> user --> 结束
        //                user边界事件signal01-->自动执行--> 结束

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("event/event-test-boundary-1.bpmn20.xml")
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
        runtimeService.startProcessInstanceByKey(processDefinition.getKey());//启动流程2

//        List<Task> tasks = taskService.createTaskQuery()
//                .taskCandidateGroup("user").list();
//        String instanceId = null;
//        String executionId = null;
//        if(tasks.size()>0){
//            Task task = tasks.get(0);
//            instanceId = task.getProcessInstanceId();
//            taskService.complete(task.getId());
//        }

        //发送信号signal-01 跳过用户活动（由于边界事件是signal，所以两个流程都订阅到该信号而同时执行下一步）
        runtimeService.signalEventReceived("signal-01");


        //启动的两个任务都完成
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();
        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances)
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + historicProcessInstance.getEndTime());

    }
}
