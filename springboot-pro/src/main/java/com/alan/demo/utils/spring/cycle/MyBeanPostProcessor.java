package com.alan.demo.utils.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description 实现BeanPostProcessor接口  细粒化spring bean 中的生命周期
 * 在 init 方法 执行之前 和执行之后  对应执行 postProcessBeforeInitialization方法  和 postProcessAfterInitialization方法
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + beanName + "," + beanName);

        if ("car".equals(beanName)) {
            // TODO: 2020/2/3  to do something 
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + beanName + "," + beanName);
        return bean;
    }
}
