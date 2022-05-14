package org.fran.demo.flowable.engine.task;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;

import java.util.Date;

public class ExecutionListener1 implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) {
		System.out.println("执行器监听任务触发了"
				+ new Date()
				+ execution.getVariable("employee"));
	}
}