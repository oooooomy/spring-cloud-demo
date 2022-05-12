package org.example.security;

import org.example.common.api.Result;
import org.example.common.util.ResponseUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Gao Yuan Ming
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("shop-user");

        //当权限不足时返回
        resources.accessDeniedHandler((request, response, exception) -> {
            ResponseUtil.writeJson(response, Result.fail(403, "权限不足"));
        });

        //当token不正确时返回
        resources.authenticationEntryPoint((request, response, exception) -> {
            ResponseUtil.writeJson(response, Result.fail(403, "Token错误"));
        });

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint((request, response, exception) -> {
                    ResponseUtil.writeJson(response, Result.fail(403, "Token缺失"));
                })

                .and()
                .authorizeRequests()

                //放行所有 根据controller的注解判断
                .anyRequest()
                .permitAll();
    }

}
