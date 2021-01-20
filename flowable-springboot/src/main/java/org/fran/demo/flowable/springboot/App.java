package org.fran.demo.flowable.springboot;

import liquibase.pro.packaged.A;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fran
 * @Description
 * @Date 2021/1/12 19:26
 */
@SpringBootApplication
@RestController
public class App {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;

    @GetMapping(value="/start")
    public String startProcess(){

        List<Deployment> r = repositoryService.createDeploymentQuery().list();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("manager", null);
        variables.put("employee", "zdb");
        variables.put("nrOfHolidays", "nrOfHolidays:zdb");
        variables.put("description", "description");

        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("holidayRequest", variables);

        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup("managers").list();
        System.out.println("You have " + tasks.size() + " tasks:");

        if(tasks.size()>0) {
            Task task = tasks.get(0);

            Map<String, Object> processVariables = taskService.getVariables(task.getId());
            System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                    processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");
            processVariables.put("approved", true);
            taskService.claim(task.getId(), "fran");
            taskService.complete(task.getId(), processVariables);
        }

        tasks = taskService.createTaskQuery().taskAssignee("zdb").list();
        System.out.println("You have " + tasks.size() + " tasks:");

        if(tasks.size()>0){
            Task task = tasks.get(0);

            Map<String, Object> processVariables = taskService.getVariables(task.getId());
            System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                    processVariables.get("nrOfHolidays") + " finish");
            taskService.complete(task.getId(), processVariables);
        }

        return "SUCCESS";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
