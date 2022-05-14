package org.fran.demo.flowable.engine.demo.event;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description 测试消息
 * @Date 2022/5/5 17:56
 */
public class EventMessageTest1 {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        //event-test-3-1 和 event-test-3-2 都使用了messageEventStart，都订阅了msg-01这个事件，所以在部署时会报错
        Deployment deployment = repositoryService.createDeployment()
//                .addClasspathResource("event/event-test-start-message-1.bpmn20.xml")
                .addClasspathResource("event/event-test-start-message-2.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        Map<String, Object> param = new HashMap<>();
        param.put("employee", "hahahah");
        runtimeService.startProcessInstanceByMessage("msg-01");

        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();
        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances)
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + historicProcessInstance.getEndTime());

    }
}
