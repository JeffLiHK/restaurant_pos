package pkpd.restaurant.config;

import pkpd.restaurant.auth.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig{
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //  SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl ，Web"/login.jsp"  "/login"
        shiroFilterFactoryBean.setLoginUrl("/sysuser/login.html");
        //
        shiroFilterFactoryBean.setSuccessUrl("/sysuser/admin.html");
        //  url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/403.html");
        //
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // ,Shiro
        filterChainDefinitionMap.put("/logout", "logout");
        //
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/image/**","anon");
        filterChainDefinitionMap.put("/layui/**","anon");
        filterChainDefinitionMap.put("/layuiadmin/**","anon");
        //
        filterChainDefinitionMap.put("/guest/**","anon");
        //
        filterChainDefinitionMap.put("/sysuser/login.do","anon");
        //<!-- ，， /** -->
        //<!-- authc:url; anon:url-->
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    //Realm
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm customRealm(){
        return new CustomRealm();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     *shiro aop.
     * ;;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public SimpleMappingExceptionResolver exceptionResolver(){
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/error/403");
        exceptionResolver.setExceptionMappings(properties);
        return exceptionResolver;
    }
}
