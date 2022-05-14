package org.fran.demo.flowable.engine.demo.event;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description 测试时间中间事件
 * @Date 2022/5/7 0:25
 */
public class IntermediateEventTest2 {
    public static void main(String[] args) {

        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")

                .setAsyncExecutorActivate(true)//设置定时任务!!

                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);


        ProcessEngine processEngine = cfg.buildProcessEngine();




        // start --> 用户任务1 --> 中间事件(调用ExecutionListener1) --> 用户2 --> end

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("event/event-test-intermediate-2.bpmn20.xml")
//                .addClasspathResource("event/event-test-error-2.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();


        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
        String s = d.format(new Date(new Date().getTime() + 1000 * 20));

        Map<String, Object> param = new HashMap<>();
        param.put("timer", s);
        param.put("user", "fran");

        ProcessInstance instance = runtimeService.
                startProcessInstanceByKey(processDefinition.getKey(), param);//启动流程1
        Map<String, Object> variables = instance.getProcessVariables();
        variables.put("timer", s);
        variables.put("user", "fran");

        System.out.println(s);
        System.out.println(new Date());

        //完成了一个
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();
        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances)
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + historicProcessInstance.getEndTime());

    }
}
