package cms.bpm.flowable;

import cms.bpm.flowable.config.DefaultBpmnConfig;
import org.flowable.bpmn.converter.BaseBpmnXMLConverter;
import org.flowable.bpmn.converter.StartEventXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.engine.*;
import org.flowable.engine.impl.bpmn.parser.BpmnParse;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

import java.util.List;
import java.util.UUID;

public class TestDeploy {
    public static void main(String[] args){
        ProcessEngineConfiguration cfg = (ProcessEngineConfiguration) new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://localhost:3306/comp_flowable?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai")
                .setJdbcUsername("root")
                .setJdbcPassword("123456")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setIdGenerator(() -> UUID.randomUUID().toString())
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine engine = cfg.buildProcessEngine();
        System.out.println(engine);

        String resourceName = "step-2.bpmn20.xml";
        String bpmXmlStr = DefaultBpmnConfig.step2Bpm;
        String key = "step-2";
        String tenantId = "default";

        repositoryService = engine.getRepositoryService();
        runtimeService = engine.getRuntimeService();
        taskService = engine.getTaskService();
        historyService = engine.getHistoryService();

        Deployment deploy = repositoryService.createDeploymentQuery()
                .deploymentKey(key)
                .deploymentTenantId(tenantId)
                .singleResult();
        if(deploy == null) {
            deploy = repositoryService.createDeployment()
                    .addString(resourceName, bpmXmlStr)
                    .key(key)
                    .tenantId(tenantId)
                    .deploy();
        }else{
            repositoryService.deleteDeployment(deploy.getId(), true);
            deploy = repositoryService.createDeployment()
                    .addString(resourceName, bpmXmlStr)
                    .key(key)
                    .tenantId(tenantId)
                    .deploy();
        }

        List<ProcessDefinition> processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(key)
                .processDefinitionTenantId(tenantId)
                .latestVersion()
                .list();

        System.out.println(processDefinition);
//        ProcessInstance instance = runtimeService.startProcessInstanceById(
//                processDefinition.getId(), param);

    }

    static RuntimeService runtimeService;
    static TaskService taskService;
    static HistoryService historyService;
    static RepositoryService repositoryService;
}
