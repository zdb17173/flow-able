package org.flowable.ui.modeler.conf;

import org.flowable.ui.common.security.SecurityConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 免登陆设置，所有接口不判断权限
 */
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
public class ModelerSecurityConfiguration {
 
    @Configuration
    @Order(SecurityConstants.MODELER_API_SECURITY_ORDER)
    public static class ModelerApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
    	
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	
        	SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
    		successHandler.setTargetUrlParameter("redirectTo");
 
    		http.headers().frameOptions().disable();
        	
        	http.csrf().disable().authorizeRequests().antMatchers("/**/**").permitAll().anyRequest().authenticated().and().httpBasic();
        }
 
    }
 
}