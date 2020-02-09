//package com.alan.demo.utils.listener;
//
//import org.springframework.boot.context.event.ApplicationPreparedEvent;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.SmartApplicationListener;
//import org.springframework.core.annotation.Order;
//
///**
// * @Description 第四种监听器的实现方式
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2019/12/20
// */
//
//@Order(4)
//public class FourthListener implements SmartApplicationListener {
//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
//        return ApplicationStartedEvent.class.isAssignableFrom(aClass) || ApplicationPreparedEvent.class.isAssignableFrom(aClass);
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        System.out.println("hello fourth");
//    }
//}
