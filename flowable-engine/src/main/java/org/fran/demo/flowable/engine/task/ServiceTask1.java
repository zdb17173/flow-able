package org.fran.demo.flowable.engine.task;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.delegate.ActivityBehavior;

import java.util.Date;

/**
 * @author fran
 * @Description
 * @Date 2022/5/5 15:16
 */
public class ServiceTask1 implements JavaDelegate {
//public class ServiceTask1 implements ActivityBehavior {

    public void execute(DelegateExecution execution) {

        //可通过execution获得流程相关信息，再通过http请求访问controller进行业务处理
//        execution.getProcessInstanceId();
//        execution.getCurrentActivityId();
//        execution.getProcessDefinitionId();
//        execution.getVariable()

        System.out.println("程序任务触发了"
                + new Date()
                + execution.getVariable("employee"));


    }
}
