package org.fran.demo.flowable.engine;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.fran.demo.flowable.engine.util.ImageService;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HolidayRequest {

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
//               .addClasspathResource("holiday-request.bpmn20.xml")
               .addClasspathResource("holidayRequest.bpmn20.xml")
               .deploy();

       ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
               .deploymentId(deployment.getId())
               .singleResult();
       System.out.println("Found process definition : " + processDefinition.getName());


       RuntimeService runtimeService = processEngine.getRuntimeService();

       Map<String, Object> variables = new HashMap<String, Object>();
       variables.put("manager", null);
       variables.put("employee", "zdb");
       variables.put("nrOfHolidays", "nrOfHolidays:zdb");
       variables.put("description", "description");

       //创建一个流程实例
       ProcessInstance processInstance =
               runtimeService.startProcessInstanceByKey("holidayRequest", variables);


       TaskService taskService = processEngine.getTaskService();
       HistoryService historyService = processEngine.getHistoryService();

       ImageService imageService = new ImageService(
               repositoryService,
               historyService,
               runtimeService
       );


       List<Task> tasks = taskService.createTaskQuery()
               .taskCandidateGroup("managers").list();
       System.out.println("You have " + tasks.size() + " tasks:");


       //处理第一步
       if(tasks.size()>0){
           Task task = tasks.get(0);

           Map<String, Object> processVariables = taskService.getVariables(task.getId());
           System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                   processVariables.get("nrOfHolidays") + " fran claim this");
           taskService.claim(task.getId(), "fran");
       }



       /* 按ID查询
       tasks = taskService.createTaskQuery()
               .taskId("13")
               .list();*/

       //返回0 因为已经被claim
       tasks = taskService.createTaskQuery()
               .taskCandidateGroup("managers").list();

       //返回1 因为已经被fran占用
       tasks = taskService.createTaskQuery()
               .taskAssignee("fran").list();

       if(tasks.size()>0){
           Task task = tasks.get(0);

           Map<String, Object> processVariables = taskService.getVariables(task.getId());
           System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                   processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");
           processVariables.put("approved", false);//false发送拒绝邮件(退回第一步)
           processVariables.put("manager", "fran");

           //设置local流程变量的时候，针对当前活动的节点设置流程变量，规则如下
           //1、若果一个流程中存在两个活动节点，针对每个活动节点都设置的流程变量。
           //2、即使流程变量的名称相同，后一次的版本的值也不会替换前一次版本的值。
           //3、他会使用不同的任务ID作为标识，存放两个流程变量值。
           //taskService.setVariableLocal();

           //可同时设置 variables（存储变量）和 transientVariables（临时变量 只用作逻辑判断不存储）
           taskService.complete(task.getId(), processVariables);
       }

       //打印流程状态图片（如需要生成实时流程状态jpg，需要使用flowable-ui制作带坐标的bpmn20.xml图
       try {
           byte[] b = imageService.generateImageByProcInstId(processInstance.getId());
           FileOutputStream out = new FileOutputStream(new File("C:\\Users\\fran\\Desktop\\flowable\\aa.jpg"));
           out.write(b);
           out.close();
       } catch (Exception e) {
           e.printStackTrace();
       }

       //返回0 因为已经被claim
       tasks = taskService.createTaskQuery()
               .taskCandidateGroup("managers").list();

       //返回1 因为通过manager参数，退回的稿件直接被fran占用
       tasks = taskService.createTaskQuery()
               .taskAssignee("fran").list();
       if(tasks.size()>0){
           Task task = tasks.get(0);
           Map<String, Object> processVariables = taskService.getVariables(task.getId());
           System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                   processVariables.get("nrOfHolidays") + " forward to holidayApprovedTask");
           processVariables.put("approved", true);//true提交至第二步
           taskService.complete(task.getId(), processVariables);
       }



       //处理第二步（因employee为zdb，该步骤flowable:assignee="${employee}" 所以该步骤直接指定给了zdb
       tasks = taskService.createTaskQuery().taskAssignee("zdb").list();
       System.out.println("You have " + tasks.size() + " tasks:");
       if(tasks.size()>0){
           Task task = tasks.get(0);

           Map<String, Object> processVariables = taskService.getVariables(task.getId());
           System.out.println( "id[" + task.getId() + "] name[" + task.getName() + "]" + processVariables.get("employee") + " wants " +
                   processVariables.get("nrOfHolidays") + " finish");
           taskService.complete(task.getId(), processVariables);
       }



       //查询进行中的流程
       //List<ProcessInstance> instances = runtimeService.createProcessInstanceQuery().list();
       System.out.println("\r\nhistory query:");

       List<HistoricActivityInstance> activities =
           historyService.createHistoricActivityInstanceQuery()
               .processInstanceId(processInstance.getId())
               .activityType("userTask")
               .finished()
               .orderByHistoricActivityInstanceEndTime().asc()
               .list();

       for (HistoricActivityInstance activity : activities) {
           System.out.println("activityId[" + activity.getActivityId()+ "]" + "type[" + activity.getActivityType() +"] took "
                   + activity.getDurationInMillis() + " milliseconds");
       }


   }

}