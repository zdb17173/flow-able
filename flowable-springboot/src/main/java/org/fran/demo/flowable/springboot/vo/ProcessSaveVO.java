package org.fran.demo.flowable.springboot.vo;

import java.util.Map;

public class ProcessSaveVO {
    private String taskId;
    private Map<String, Object> data;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
