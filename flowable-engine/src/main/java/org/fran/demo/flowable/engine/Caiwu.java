package org.fran.demo.flowable.engine;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.fran.demo.flowable.engine.util.ImageService;
import org.fran.demo.flowable.engine.util.FlowableDiagramGenerator;

import java.io.File;
import java.util.*;

/**
 * @author fran
 * @Description
 * @Date 2022/5/4 15:44
 */
public class Caiwu {
    public static void main(String[] args){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
//               .addClasspathResource("holiday-request.bpmn20.xml")
                .addClasspathResource("caiwu.bpmn20.xml")
                .deploy();


        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());



        RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("account", 1000);
        variables.put("employee", "zdb");
        variables.put("nrOfHolidays", "nrOfHolidays:zdb");
        variables.put("description", "description");

        //创建一个流程实例
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("baoxiao", variables);

        TaskService taskService = processEngine.getTaskService();

        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("caiwu").list();
        System.out.println("You have " + tasks.size() + " tasks:");


        if(tasks.size()>0) {
            Task task = tasks.get(0);

            taskService.claim(task.getId(), "fran");
        }

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("caiwu").list();

        //返回1 因为已经被fran占用
        tasks = taskService.createTaskQuery()
                .taskAssignee("fran").list();

        if(tasks.size()>0){
            Task task = tasks.get(0);

            Map<String, Object> processVariables = taskService.getVariables(task.getId());

            //可同时设置 variables（存储变量）和 transientVariables（临时变量 只用作逻辑判断不存储）
            taskService.complete(task.getId(), processVariables);
        }

        FlowableDiagramGenerator gen = new FlowableDiagramGenerator(processEngine);

        gen.draw(processInstance.getId(),
                new File("C:\\Users\\fran\\Desktop\\flowable\\aa1.jpg"));
        gen.drawByLiuxz(processInstance.getId(),
                new File("C:\\Users\\fran\\Desktop\\flowable\\aa2.jpg"));

        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("caiwuzhuguan").list();

        System.out.println("caiwuzhuguan:" + tasks.size());

        if(tasks.size()>0) {
            Task task = tasks.get(0);
            Map<String, Object> processVariables = taskService.getVariables(task.getId());

//          驳回
//            String parentTaskId = task.getParentTaskId();
//            List<Task> parentTask = taskService.createTaskQuery().taskId(parentTaskId).list();
//            if(parentTask!= null && parentTask.size()>0){
//                Task pt = parentTask.get(0);
//
//                runtimeService.getActiveActivityIds()
//
//                runtimeService.createChangeActivityStateBuilder()
//                        .processInstanceId(pt.getProcessInstanceId())
//                        .move
//            }



            taskService.complete(task.getId(), processVariables);
        }


        tasks = taskService.createTaskQuery()
                .taskCandidateGroup("ceo").list();

        System.out.println("seo:" + tasks.size());

        //使用 historyService 验证进程是否已结束
        HistoryService historyService = processEngine.getHistoryService();
        HistoricProcessInstance historicProcessInstance =
                historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
    }
}
