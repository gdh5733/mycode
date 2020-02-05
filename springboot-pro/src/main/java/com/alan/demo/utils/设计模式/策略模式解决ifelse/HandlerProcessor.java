package com.alan.demo.utils.设计模式.策略模式解决ifelse;

import com.google.common.collect.Maps;
import jodd.io.findfile.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {


    private static final String HANDLER_PACKAGE = "com.cipher.handler_demo.handler.biz";


    /**
     * 扫描@HandlerType,初始化HandlerContext,将其注册到spring容器
     *
     * @param configurableListableBeanFactory beanFactory工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
//        configurableListableBeanFactory.registerSingleton();
//        ClassScanner.scan
    }
}
