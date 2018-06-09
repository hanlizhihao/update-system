package com.thinking.update.main.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.annotation.Resource;

/**
 * @author hanlizhi
 * @create 2017-11-29 20:38
 */
@EnableOAuth2Sso
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private DruidDataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/docs/**",
                "common/**", "error/**", "system/**", "swagger-ui.html");
    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,true from users where username=?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username=?");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认开启防止csrf攻击,登录登出不过滤
        http
                .formLogin()
                .loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/").and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
//                .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .clearAuthentication(true)
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login?logout")
//                    .deleteCookies("SESSION")
//                .and()
//                    .rememberMe()//开启记住我功能
//                    //记住一周
//                    .tokenValiditySeconds(606800)
//                    //存储在cookie中的token包含用户名、密码、过期时间和一个私钥--在写入Cookie前都进行了MD5哈希，默认私钥为SpringSecured
//                    // 这里改为management
//                    .key("management")
//                .and()
//                .and()
//                .requiresChannel()
//                    .antMatchers("/login")
//                    .requiresSecure()
//                    .and()
//                    .httpBasic()
//                .and()
//                    .sessionManagement()
//                    .invalidSessionUrl("/login")
//                    .maximumSessions(1)
//                    .expiredUrl("/login?expired");
    }
}
