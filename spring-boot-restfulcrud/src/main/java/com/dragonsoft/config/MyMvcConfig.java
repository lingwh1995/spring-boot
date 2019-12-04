package com.dragonsoft.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author ronin
 */
@Configuration
public class MyMvcConfig {

    /**
     * 配置tomcat启动信息的bean
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory(){
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setPort(8080);
        return tomcat;
    }

    /**
     * EmbeddedServletContainerAutoConfiguration中注册TomcatEmbeddedServletContainerFactory的代码
     * @return
     */
//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
//        return new TomcatEmbeddedServletContainerFactory();
//    }


    @Bean
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry){
//                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
