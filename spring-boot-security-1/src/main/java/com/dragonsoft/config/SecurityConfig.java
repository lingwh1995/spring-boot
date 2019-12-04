package com.dragonsoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ronin
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 定制授权规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求访问的授权规则:访问/hello直接放行,访问/vip登录成功后必须有vip1这个角色才能访问
        http.authorizeRequests().antMatchers("/","/hello").permitAll()
                .antMatchers("/vip1").hasRole("vip1");
        //开启自动配置的登录功能,如果没有权限就重定向到403页面、
            //如果用户名或者密码输入错误,则重定向到:/login?error
        http.formLogin();
        //开启自动配置的注销功能:
        // 1.访问 /logout会退出并清空Session       2.必须是post请求
            //配置注销成功去访问 /index 路径
        http.logout().logoutSuccessUrl("/");
    }

    /**
     * 定义认证规则
     *      密码存储在内存中,并且进行了加密
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3")
                .and()
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");
    }
}
