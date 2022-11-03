package cms.bpm.flowable.service;

import cms.bpm.flowable.dto.BpmnModelDto;
import cms.bpm.flowable.dto.FlowDto;
import cms.bpm.flowable.dto.FlowResult;

import java.util.List;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/11/2
 */
public interface IProcessFlowService {

    /**
     * 占有任务（退回、提交等操作都需先进行占有）
     * @param taskId
     * @return
     */
    Map<String, Object> edit(String taskId);

    /**
     * 任务提交（流转至下一个节点，当无下一个节点时，isEnd=true流程结束）
     * @param taskDto
     * @return
     */
    FlowResult submit(FlowDto taskDto);

    /**
     * 任务保存（主要更新varibales）
     * @param taskDto
     */
    void save(FlowDto taskDto);

    /**
     * 流程退回
     * @param taskId 当前任务ID
     * @param targetUserTaskId 退回到哪一个任务的nodeKey
     */
    void sendBack(String taskId, String targetUserTaskId);

    /**
     * 查询该任务以往的节点
     * @param taskId
     * @return
     */
    List<BpmnModelDto.BpmnUserTaskDto> getBeforeUserTasks(String taskId);
}
