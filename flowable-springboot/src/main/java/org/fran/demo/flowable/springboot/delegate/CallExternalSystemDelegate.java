package org.fran.demo.flowable.springboot.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author fran
 * @Description
 * @Date 2021/1/18 14:39
 */
public class CallExternalSystemDelegate implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        System.out.println("CallExternalSystemDelegate "
                + execution.getVariable("employee"));
    }
}
