package cms.bpm.flowable.config;

import cms.bpm.flowable.service.IProcessUserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiushi
 * @date 2022/10/31
 */
@Configuration
public class ProcessUserConfig {

    @ConditionalOnMissingBean(IProcessUserService.class)
    @Bean
    IProcessUserService processUserService(){
        return new IProcessUserService(){
            ThreadLocal<ProcessUser> tl = new ThreadLocal<>();

            @Override
            public void setCurrentUser(ProcessUser processUser) {
                tl.set(processUser);
            }

            @Override
            public ProcessUser getCurrentUser() {
                return tl.get();
            }
        };
    }
}
