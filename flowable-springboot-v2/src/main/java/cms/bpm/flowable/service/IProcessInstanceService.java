package cms.bpm.flowable.service;

import cms.bpm.flowable.dto.CreateProcessDto;
import cms.bpm.flowable.dto.ProcessInstanceDto;

import java.util.Map;

/**
 * 流程实例，基于流程定义，创建流程实例、对已存在流程实例进行处理
 * @author qiushi
 * @date 2022/11/2
 */
public interface IProcessInstanceService {

    /**
     * 创建流程实例
     * @param createDto
     * @return
     */
    ProcessInstanceDto startProcess(CreateProcessDto createDto);

    /**
     * 根据实例id，查询流程的全局属性
     * @param instanceId
     * @return
     */
    Map<String, Object> getInstanceVariables(String instanceId);

    /**
     * 废弃流程
     * @param instanceId
     */
    void drop(String instanceId);
}
