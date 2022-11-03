package org.fran.demo.flowable.springboot.vo;

import java.util.Map;

public class ProcessEditVO {
    private String taskId;
    private String taskName;
    private String instanceId;
    private Map<String, Object> data;

    public ProcessEditVO(){}

    public ProcessEditVO(String taskId, String taskName, String instanceId, Map<String, Object> data) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.instanceId = instanceId;
        this.data = data;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
            this.data = data;
        }
}
