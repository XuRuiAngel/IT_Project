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
                registry.addViewController("/RLLogin").setViewName("RLLogin");
                registry.addViewController("/admin").setViewName("admin");
                registry.addViewController("/recoverpsw").setViewName("recoverpsw");
                registry.addViewController("/createLi").setViewName("createLi");
                registry.addViewController("/createReader").setViewName("createReader");
                registry.addViewController("/librarian").setViewName("librarian");
                registry.addViewController("/search").setViewName("search");
                registry.addViewController("/welcomeAdmin").setViewName("welcomeAdmin");
                registry.addViewController("/welcomeLi").setViewName("welcomeLi");
                registry.addViewController("/setFin").setViewName("setFine");
                registry.addViewController("/setPerio").setViewName("setPeriod");
                registry.addViewController("/setDeposi").setViewName("setDeposit");
                registry.addViewController("/eidtAddDeleteAccount").setViewName("eidtAddDeleteAccount");
                registry.addViewController("/ISBN").setViewName("ISBN");
                registry.addViewController("/add").setViewName("add");
    }
};
        return adapter;
    }
}
