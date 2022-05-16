package org.fran.demo.flowable.engine.demo.gateway;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * @author fran
 * @Description parallelGateway并行网关测试
 * @Date 2022/5/14 22:50
 */
public class GatewayTest3 {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("gateway/gateway-test-3.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        ProcessInstance instance = runtimeService.startProcessInstanceById(processDefinition.getId());

        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user1").list();
        String instanceId = null;
        String executionId = null;
        System.out.println("任务1:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            taskService.complete(task.getId());
        }

        //直接获取任务3失败，因并行网关需要等 任务1 and 任务2均完成才可以
        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user3").list();
        System.out.println("任务3:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            taskService.complete(task.getId());
        }

        queryHistory(historyService);

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user2").list();
        System.out.println("任务2:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            taskService.complete(task.getId());
        }

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("user3").list();
        System.out.println("任务3:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            taskService.complete(task.getId());
        }

        queryHistory(historyService);
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
