package com.thinking.update.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author Administrator
 * @create 2018/5/12
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//        关闭csrf
//        .csrf().disable()
        //取消安全报文头 默认开启  可配置部分开启或全关
        //.headers().disable()
        //登录页面url 配置登录成功后调用的方法
                .formLogin().loginPage("/login").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
            //配置这些链接无需验证
                .antMatchers("/regist", "/toregist").permitAll()
            //除以上路径都需要验证
                .anyRequest().authenticated()
            //路径角色验证
            //.antMatchers("/admin/**").hasRole("ADMIN")
            //排除该路径角色认证  注意顺序自上而下
            //.antMatchers("/**").hasRole("USER")
                .and()
                //注销登录  默认支持 销毁session并且清空配置的rememberMe()认证 跳转登录页 或配置的注销成功页面
                .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(false)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logoutsuccess")
                .and()
                //http参数中包含一个名为“remember-me”的参数，不管session是否过期，用户记录将会被记保存下来
                .rememberMe()
                //.and()
                ////http映射https
                //.portMapper()
                //.http(8080).mapsTo(9443)
                .and()
                //配置http认证
                .httpBasic()
                .and()
                //当用户进行重复登录时  强制销毁前一个登录用户  配置此应用必须添加Listener  HttpSessionEventPublisher
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager)
                .inMemoryAuthentication()
                .withUser("john").password("123").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/assets/**");
    }
}
