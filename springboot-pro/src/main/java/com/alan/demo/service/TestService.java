package com.alan.demo.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/18
 */

@Component
public class TestService implements ApplicationContextAware {

    private  ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
             this.applicationContext =applicationContext;
    }

    public String test(){
        return applicationContext.getEnvironment().getProperty("key3");
    }
}
