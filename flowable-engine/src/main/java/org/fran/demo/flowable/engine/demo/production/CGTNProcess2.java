package org.fran.demo.flowable.engine.demo.production;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二审流程demo
 */
public class CGTNProcess2 {
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
                .addClasspathResource("production/cgtn-2.bpmn20.xml")
                .deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        Map<String, Object> param = new HashMap<>();
        param.put("creator", "ab,aa");//ab & aa都可以查询到任务
        param.put("reviewer1", "coo");
        param.put("reviewer2", "fran");

        ProcessInstance instance = runtimeService.startProcessInstanceById(
                processDefinition.getId(), param);

        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("aa").list();

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("ab").list();
        String instanceId = null;
        String executionId = null;
        System.out.println("任务1:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            Map<String, Object> param1 = new HashMap<>();
            param1.put("sendBack", "1");
            taskService.complete(task.getId(), param1);

            instance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .singleResult();
            System.out.println("流程结束{" + instance.isEnded() + "}");
        }


        queryHistory(historyService);

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("coo").list();
        System.out.println("任务2:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            Map<String, Object> param1 = new HashMap<>();
            param1.put("sendBack", "1");
            taskService.complete(task.getId(), param1);
        }


        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("fran").list();
        System.out.println("任务3:" + tasks.size());
        if(tasks.size()>0){
            Task task = tasks.get(0);
            instanceId = task.getProcessInstanceId();
            Map<String, Object> param1 = new HashMap<>();
            param1.put("sendBack", "1");
            taskService.complete(task.getId(), param1);

            instance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId())
                    .singleResult();
            if(instance!= null)
            System.out.println("流程结束{" + instance.isEnded() + "}");
        }

        queryHistory(historyService);
    }

    public static void queryHistory(HistoryService historyService){
        //启动的两个任务都完成
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(instanceId)
                .list();

        for(HistoricProcessInstance historicProcessInstance : historicProcessInstances) {
            System.out.println("Process instance end time: " + historicProcessInstance.getProcessDefinitionKey() + " " + historicProcessInstance.getEndTime());
            Map<String, Object> variables = historicProcessInstance.getProcessVariables();

            List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery()
                    .processInstanceId(historicProcessInstance.getSuperProcessInstanceId())
                    .list();
            tasks.get(0).getId();

            System.out.println(tasks);
        }
    }
}
