package org.fran.demo.flowable.springboot.config;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class FlowableConfigure implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {
    @Resource
    RepositoryService repositoryService;

    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
        // advanced configuration

    }
}
