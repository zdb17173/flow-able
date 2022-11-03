package org.fran.demo.flowable.springboot.service;

import org.flowable.task.api.history.HistoricTaskInstance;
import org.fran.demo.flowable.springboot.service.impl.process.ProcessTaskList;
import org.fran.demo.flowable.springboot.vo.ProcessEditVO;
import org.fran.demo.flowable.springboot.vo.TaskVO;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface ProcessService {
    /**
     * 启动流程
     * @param processDefinitionId
     */
    public void startProcess(Long processDefinitionId);

    /**
     * 保存流程数据
     * @param taskId
     * @param variables
     */
    void save(String taskId, Map<String, Object> variables);

    /**
     * 获取流程数据(占有流程)
     * @param taskId
     * @return
     */
    ProcessEditVO edit(String taskId);

    /**
     * 流程前进
     * @param taskId
     * @param nextOwnerId
     * @param variables
     */
    void submit(String taskId, String nextOwnerId, Map<String, Object> variables);

    void sendBack(String taskId);

    /**
     * 绘制流程图
     * @param instanceId
     * @param outputStream
     */
    void draw(String instanceId, OutputStream outputStream);

    /**
     * 查询任务
     * @param taskListType OWNED查询已占有的 INPOOL查询池子中的  ALL查询已占有&池子的
     * @return
     */
    List<TaskVO> tasks(TaskListType taskListType, int start, int max);


    List<HistoricTaskInstance> historic(String instanceId);

    enum TaskListType{
        OWNED, INPOOL, ALL
    }
}
