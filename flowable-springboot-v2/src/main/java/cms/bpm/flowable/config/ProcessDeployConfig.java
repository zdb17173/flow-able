package cms.bpm.flowable.config;

import cms.bpm.flowable.service.IProcessDefinitionService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * 流程部署配置，自动进行流程定义初始化
 * @author qiushi
 * @date 2022/10/31
 */
@Configuration
@Slf4j
public class ProcessDeployConfig {
    @Resource
    RepositoryService repositoryService;
    @Resource
    ResourcePatternResolver resourcePatternResolver;
    @Resource
    IProcessDefinitionService processDefinitionService;

    @PostConstruct
    public void initProcessDeploy() {
        try{
            Map<String, String> defBpm = DefaultBpmnConfig.defaultBpm;
            for(String key : defBpm.keySet()){
                processDefinitionService.createProcessDeploy(
                        DefaultBpmnConfig.DEFAULT_TENANT_ID,
                        key,
                        defBpm.get(key)
                );
            }
        }catch (Exception e){
            log.error("初始化流程定义失败", e);
            throw e;
        }
    }

    //扫描class目录方式 暂时不用
    public List<org.springframework.core.io.Resource> discoverDeploymentResources(String prefix, List<String> suffixes, boolean loadResources) throws IOException {
        if (loadResources) {
            List<org.springframework.core.io.Resource> result = new ArrayList();
            Iterator var5 = suffixes.iterator();

            while(var5.hasNext()) {
                String suffix = (String)var5.next();
                String path = prefix + suffix;
                org.springframework.core.io.Resource[] resources = this.resourcePatternResolver.getResources(path);
                if (resources != null && resources.length > 0) {
                    Collections.addAll(result, resources);
                }
            }

            if (result.isEmpty()) {
            }

            return result;
        } else {
            return new ArrayList();
        }
    }
}
