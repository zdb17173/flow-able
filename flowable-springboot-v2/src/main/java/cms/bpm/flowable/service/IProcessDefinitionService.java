package cms.bpm.flowable.service;

import cms.bpm.flowable.dto.BpmnModelDto;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * 流程定义，查看所有可创建的流程定义等
 * @author qiushi
 * @date 2022/11/2
 */
public interface IProcessDefinitionService {

    /**
     * 查看所有流程
     * @param tenantId 租户id
     * @return
     */
    List<BpmnModelDto> listProcess(String tenantId);

    /**
     * 查看所有
     * @param processDefinitionId 流程定义ID
     * @param tenantId 租户id
     * @return
     */
    BpmnModelDto getProcessDefinitionById(String tenantId, String processDefinitionId);

    /**
     * 创建新的流程定义，如已存在，则返回之前定义的流程
     * @param tenant
     * @param key
     * @param bpmXml
     * @return
     */
    Deployment createProcessDeploy(String tenant, String key, String bpmXml);

    /**
     * 创建新的流程定义，如已存在，则返回之前定义的流程 或 更新
     * @param tenant
     * @param key
     * @param bpmXml
     * @param update 如已存在是否更新（更新会删除该流程的所有历史记录及处理中的实例）
     * @return
     */
    Deployment createProcessDeploy(String tenant, String key, String bpmXml, boolean update);

    /**
     * 缓存流程定义结构
     * @param pd
     */
    BpmnModelDto cacheBpmnModel(ProcessDefinition pd);

    /**
     * 缓存全部流程定义结构
     */
    void cacheAllBpmnModel();
}
