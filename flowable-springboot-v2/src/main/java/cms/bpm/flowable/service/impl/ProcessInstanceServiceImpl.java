package cms.bpm.flowable.service.impl;

import cms.bpm.flowable.dto.BpmnModelDto;
import cms.bpm.flowable.dto.CreateProcessDto;
import cms.bpm.flowable.dto.ProcessInstanceDto;
import cms.bpm.flowable.exceptions.ProcessException;
import cms.bpm.flowable.service.IProcessDefinitionService;
import cms.bpm.flowable.service.IProcessInstanceService;
import cms.bpm.flowable.service.IProcessUserService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/11/2
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProcessInstanceServiceImpl extends ProcessCommon implements IProcessInstanceService {

    @Override
    public ProcessInstanceDto startProcess(CreateProcessDto createDto) {
        IProcessUserService.ProcessUser user = getCurrUser();
        String tenantId = user.getTenant();

        BpmnModelDto pd = processDefinitionService.getProcessDefinitionById(tenantId, createDto.getProcessDefinitionId());
        if(pd == null)
            throw new ProcessException("未找到匹配的流程");

        Map<String, Object> param = new HashMap<>();
        param.put(VARIABLE_CREATE_USER_ID, user.getId());
        param.put(VARIABLE_CREATE_USER_NAME, user.getName());
        param.putAll(createDto.getVariables());

        ProcessInstance instance = runtimeService.
                startProcessInstanceById(
                        createDto.getProcessDefinitionId(),
                        createDto.getBusinessKey(),
                        param);
        return new ProcessInstanceDto(
                instance.getId(),
                instance.getBusinessKey(),
                instance.getStartTime()
        );
    }

    @Override
    public Map<String, Object> getInstanceVariables(String instanceId){
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .includeProcessVariables()
                .singleResult();
        return instance.getProcessVariables();
    }

    @Override
    public void drop(String instanceId) {
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .includeProcessVariables()
                .singleResult();
        if(instance == null)
            throw new ProcessException("未找到流程，废弃失败");

        runtimeService.deleteProcessInstance(instanceId, "");
        historyService.deleteHistoricProcessInstance(instanceId);
    }

    @Resource
    IProcessDefinitionService processDefinitionService;
}
