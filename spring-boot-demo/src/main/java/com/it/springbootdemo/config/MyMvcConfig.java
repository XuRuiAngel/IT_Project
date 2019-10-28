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
                registry.addViewController("/search1").setViewName("search1");
                registry.addViewController("/search2").setViewName("search2");
                registry.addViewController("/search3").setViewName("search3");
                registry.addViewController("/welcomeAdmin").setViewName("welcomeAdmin");
                registry.addViewController("/welcomeLi").setViewName("welcomeLi");
                registry.addViewController("/setFin").setViewName("setFine");
                registry.addViewController("/setPerio").setViewName("setPeriod");
                registry.addViewController("/setDeposi").setViewName("setDeposit");
                registry.addViewController("/eidtAddDeleteAccount").setViewName("eidtAddDeleteAccount");
                registry.addViewController("/lendBook").setViewName("lendBook");
                registry.addViewController("/News").setViewName("News");
                registry.addViewController("/add").setViewName("add");
                registry.addViewController("/ISBN").setViewName("ISBN");
                registry.addViewController("/success").setViewName("success");
                registry.addViewController("/reader").setViewName("reader");
                registry.addViewController("/manageReaderAccount").setViewName("manageReaderAccount");
                registry.addViewController("/information").setViewName("information");
                registry.addViewController("/changepsw").setViewName("changepsw");
                registry.addViewController("/ReturnBook").setViewName("ReturnBook");
                registry.addViewController("/view").setViewName("view");
                registry.addViewController("/welcomeR").setViewName("welcomeR");
                registry.addViewController("/borrow").setViewName("borrow");
                registry.addViewController("/fineRecord").setViewName("fineRecord");
                registry.addViewController("/incomeRecord").setViewName("incomeRecord");
                registry.addViewController("/ViewDeletionRecord").setViewName("ViewDeletionRecord");
                registry.addViewController("/1").setViewName("1");
                registry.addViewController("/ViewNews").setViewName("ViewNews");
            }
        };
        return adapter;
    }
}
