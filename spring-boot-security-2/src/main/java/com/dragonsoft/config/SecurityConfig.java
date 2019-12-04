package com.dragonsoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ronin
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 定制认证规则
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                //passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 定制授权规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//禁用了 csrf 功能
            .csrf().disable()
            //限定签名成功的请求
            .authorizeRequests()
            //对decision、govern、employee下的接口 需要 EMPLOYEE 或者 ADMIN 权限
            .antMatchers("/decision/**","/govern/**","/employee/*").hasAnyRole("EMPLOYEE","ADMIN")
            // /employee/login 不限定
            .antMatchers("/employee/login").permitAll()
            //对admin下的接口 需要ADMIN权限
            .antMatchers("/admin/**").hasRole("ADMIN")
            //不拦截 oauth 开放的资源
            .antMatchers("/oauth/**").permitAll()
            //其他没有限定的请求，允许访问
            .anyRequest().permitAll()
            //对于没有配置权限的其他请求允许匿名访问
            .and().anonymous()
            //使用 spring security 默认登录页面
            .and().formLogin()
            //启用http 基础验证
            .and().httpBasic();
    }
}
