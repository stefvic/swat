package com.swat.mercedes.fe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.swat.mercedes.fe.controllers.SampleController;

@Configuration
public class ContextConfig {
    @Bean
    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
            return new DefaultAnnotationHandlerMapping();
    }
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/views/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
    }
    
    @Bean
    public SampleController sampleController(){
	return new SampleController();
    }
    
    public void test(){
	
    }
}
