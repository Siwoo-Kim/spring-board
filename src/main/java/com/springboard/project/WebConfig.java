package com.springboard.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/* Web application configuration */
@Configuration
@ComponentScan(basePackages = "com.springboard.project.controller")
public class WebConfig extends WebMvcConfigurationSupport{


    /* ViewResolver which find the view by the view name */
    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
            /* view path = /WEB-INF/view/[veiwName].jsp */
        return viewResolver;
    }



    /*
        static resource handlers
        css , javascript, img,  etc
    */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/static/");   /* css && javascript */
        registry.addResourceHandler("/webjars/bootstrap/**").addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/dist/"); /* bootstrap && jquery */
        registry.addResourceHandler("/webjars/jquery/**").addResourceLocations("classpath:/META-INF/resources/webjars/jquery/2.1.3/dist/"); /* bootstrap && jquery */
    }


    @Bean(name = "homeView")
    String homeView(){    return "home";    }

}
