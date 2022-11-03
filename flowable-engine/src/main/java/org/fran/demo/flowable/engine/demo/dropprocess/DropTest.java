package org.fran.demo.flowable.engine.demo.dropprocess;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.*;

public class DropTest {
    static RuntimeService runtimeService;
    static TaskService taskService;
    static HistoryService historyService;
    static RepositoryService repositoryService;

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
                .addClasspathResource("production/cgtn-3.bpmn20.xml")
                .deploy();

        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        historyService = processEngine.getHistoryService();
        repositoryService = processEngine.getRepositoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();

        Map<String, Object> param = new HashMap<>();
        param.put("node1", "n11,n12,n13");
        param.put("node2", "n21,n22");
        param.put("node3", "n31,n32,n33,n34");
        param.put("node4", "n41,n42");

        ProcessInstance instance = runtimeService.startProcessInstanceById(
                processDefinition.getId(), param);

        //第一个节点
        String curUser = "n11";
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        System.out.println("task:"+ tasks.size());

        //删除
        runtimeService.deleteProcessInstance(instance.getId(), "hha");
        historyService.deleteHistoricProcessInstance(instance.getId());
        //删除

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup(curUser).list();
        System.out.println("task:"+ tasks.size());
        List<HistoricProcessInstance> instanceHis = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(instance.getId())
                .list();
        System.out.println("hisIns" + instanceHis.size());
        List<HistoricTaskInstance> tasksHis = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(instance.getId())
                .list();
        System.out.println("hisTask" + tasksHis.size());

    }

}
