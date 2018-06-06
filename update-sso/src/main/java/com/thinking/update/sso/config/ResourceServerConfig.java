package com.thinking.update.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2018/6/6
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
/*    *//**
     * 自定义登录成功处理器
     *//*
    @Resource
    private AuthenticationSuccessHandler appLoginInSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //登录成功处理器
                .successHandler(appLoginInSuccessHandler)
                .and()
                .authorizeRequests().anyRequest().authenticated().and()
                .csrf().disable();
    }*/

}
