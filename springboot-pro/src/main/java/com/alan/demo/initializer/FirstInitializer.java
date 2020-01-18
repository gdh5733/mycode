//package com.alan.demo.initializer;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.MapPropertySource;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Description 自定义系统初始化器
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2019/12/18
// */
//
////@Order(1)
//public class FirstInitializer implements ApplicationContextInitializer {
//    @Override
//    public void initialize(ConfigurableApplicationContext applicationContext) {
//
//        ConfigurableEnvironment  environment = applicationContext.getEnvironment();
//         Map<String,Object> map = new HashMap<>();
//         map.put("key1","value1");
//         MapPropertySource mapPropertySource =  new MapPropertySource("firstInitializer",map);
//         environment.getPropertySources().addLast(mapPropertySource);
//        System.out.println("run FirstInitializer");
//
//    }
//}
