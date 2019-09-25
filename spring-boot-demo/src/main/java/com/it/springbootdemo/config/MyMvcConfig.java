package com.it.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("123").setViewName("test");
    }

    @Bean
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override
            //添加视图映射
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/11").setViewName("test");
                registry.addViewController("/ALogin").setViewName("ALogin");
            }
        };
        return adapter;
    }
}
