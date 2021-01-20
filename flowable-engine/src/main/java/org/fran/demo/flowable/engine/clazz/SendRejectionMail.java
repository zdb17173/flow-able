package org.fran.demo.flowable.engine.clazz;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author fran
 * @Description
 * @Date 2021/1/18 14:39
 */
public class SendRejectionMail implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        System.out.println("SendRejectionMail "
                + execution.getVariable("employee"));
    }
}
