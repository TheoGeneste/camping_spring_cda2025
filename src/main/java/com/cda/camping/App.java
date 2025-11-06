package com.cda.camping;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.cda.camping.config.AppConfig;

public class App extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[] {AppConfig.class};
    }
    
    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }

}


