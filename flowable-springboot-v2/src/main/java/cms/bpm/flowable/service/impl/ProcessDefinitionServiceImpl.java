package cms.bpm.flowable.service.impl;

import cms.bpm.flowable.config.DefaultBpmnConfig;
import cms.bpm.flowable.dto.BpmnModelDto;
import cms.bpm.flowable.service.IProcessDefinitionService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiushi
 * @date 2022/11/2
 */
@Service
@Slf4j
public class ProcessDefinitionServiceImpl implements IProcessDefinitionService {
    @Resource
    RepositoryService repositoryService;

    @Override
    public Deployment createProcessDeploy(String tenant, String key, String bpmXml){
        return createProcessDeploy(tenant, key, bpmXml, false);
    }

    @Override
    public Deployment createProcessDeploy(String tenant, String key, String bpmXml, boolean update){
        if(tenant == null)
            tenant = DefaultBpmnConfig.DEFAULT_TENANT_ID;

        Deployment deploy = repositoryService.createDeploymentQuery()
                .deploymentKey(key)
                .deploymentTenantId(tenant)
                .singleResult();

        if(deploy == null){
            deploy = repositoryService.createDeployment()
                    .addString(key + ".bpmn20.xml", bpmXml)
                    .key(key)
                    .tenantId(DefaultBpmnConfig.DEFAULT_TENANT_ID)
                    .deploy();
        }else{
            if(update){
                repositoryService.deleteDeployment(deploy.getId(), true);

                cleanBpmnModelCache(deploy.getId());

                deploy = repositoryService.createDeployment()
                        .addString(key + ".bpmn20.xml", bpmXml)
                        .key(key)
                        .tenantId(DefaultBpmnConfig.DEFAULT_TENANT_ID)
                        .deploy();
            }
        }

        List<ProcessDefinition> pd = repositoryService.createProcessDefinitionQuery()
                .processDefinitionTenantId(tenant)
                .deploymentId(deploy.getId())
                .list();
        if(pd != null && pd.size() > 0)
            cacheBpmnModel(pd.get(0));

        return deploy;
    }

    private void cleanBpmnModelCache(String deployId){
        for(BpmnModelDto bpmn : bpmnCache.values()){
            if(bpmn.getDeployId().equals(deployId)){
                bpmnCache.remove(bpmn.getProcessDefinitionId());
            }
        }
    }

    @Override
    public BpmnModelDto cacheBpmnModel(ProcessDefinition pd){
        BpmnModel model = repositoryService.getBpmnModel(pd.getId());
        if(model.getProcesses() == null || model.getProcesses().size() == 0)
            return null;

        Process process = model.getProcesses().get(0);
        String pid = process.getId();
        String pName = process.getName();

        List<BpmnModelDto.BpmnUserTaskDto> userTasks = new ArrayList<>();
        BpmnModelDto bpmnDto = new BpmnModelDto(
                pd.getId(),
                pd.getDeploymentId(),
                pd.getTenantId(),
                pid,
                pName,
                userTasks);

        Collection<FlowElement> elements = process.getFlowElements();
        for( FlowElement element : elements) {
            if( element instanceof UserTask) {
                UserTask userTask = (UserTask) element;
                String tid = userTask.getId();
                String tName = userTask.getName();
                List<String> tGroup = userTask.getCandidateGroups();
                userTasks.add(new BpmnModelDto.BpmnUserTaskDto(
                        tid,
                        tName,
                        tGroup
                ));
            }
        }

        bpmnCache.put(pd.getId(), bpmnDto);
        return bpmnDto;
    }

    @Override
    public void cacheAllBpmnModel(){
        List<ProcessDefinition> pdList = repositoryService.createProcessDefinitionQuery()
                .list();
        if(pdList!= null && pdList.size() > 0){
            for(ProcessDefinition pd : pdList){
                cacheBpmnModel(pd);
            }
        }
    }

    @Override
    public List<BpmnModelDto> listProcess(String tenantId){
        if(tenantId == null)
            return new ArrayList<>(bpmnCache.values());
        else
            return new ArrayList<>(bpmnCache.values())
                .stream().filter( p -> p.getTenantId() == null? true :p.getTenantId().equals(tenantId))
                .collect(Collectors.toList());
    }

    @Override
    public BpmnModelDto getProcessDefinitionById(String tenantId, String processDefinitionId){
        if(bpmnCache.containsKey(processDefinitionId))
            return bpmnCache.get(processDefinitionId);
        else{
            ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(processDefinitionId)
                    .processDefinitionTenantId(tenantId)
                    .singleResult();
            BpmnModelDto bpmnDto = cacheBpmnModel(pd);
            return bpmnDto;
        }
    }

    //key -> processDefinitionId
    static Map<String, BpmnModelDto> bpmnCache = new HashMap<>();
}
