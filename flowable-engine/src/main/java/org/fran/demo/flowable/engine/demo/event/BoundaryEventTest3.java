package org.fran.demo.flowable.engine.demo.event;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description
 * @Date 2022/5/5 18:44
 */
public class BoundaryEventTest3 {

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        //部署了两个signalEvent 都订阅了signal01这个信号，当发送signal01信号时，会同时启动两个流程
        //流程  start --> 并行网关  --> user1(补偿事件ServiceTask1) --> 并行网关 --> 抛出补偿事件 --> 结束
        //                             user2(补偿事件ServiceTask1) -->

        //注意：补偿事件的活动 需要勾上isForCompensation！！！ 例如上述例子中“自动执行”就需要勾上

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("event/event-test-boundary-3.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        Map<String, Object> param = new HashMap<>();
        param.put("employee", "hahahah");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinition.getKey());//启动流程1
        runtimeService.startProcessInstanceByKey(processDefinition.getKey());//启动流程2

        List<Task> tasks = null;

        tasks = taskService.createTaskQuery()
                .taskCandidateUser("user1").list();
        if(tasks.size()>0){
            Task task = tasks.get(0);
            taskService.complete(task.getId());
        }

        tasks = taskService.createTaskQuery()
                .taskCandidateUser("user2").list();
        if(tasks.size()>0){
            Task task = tasks.get(0);
            taskService.complete(task.getId());
        }

        //此时触发了补偿事件
        //user1 执行补偿事件
        //user2 执行补偿事件

        tasks = taskService.createTaskQuery()
                .taskCandidateUser("user3").list();
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
