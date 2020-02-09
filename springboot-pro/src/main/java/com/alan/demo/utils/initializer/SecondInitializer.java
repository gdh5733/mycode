//package com.alan.demo.utils.initializer;
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
////@Order(2)
//public class SecondInitializer implements ApplicationContextInitializer {
//    @Override
//    public void initialize(ConfigurableApplicationContext applicationContext) {
//
//        ConfigurableEnvironment  environment = applicationContext.getEnvironment();
//         Map<String,Object> map = new HashMap<>();
//         map.put("key2","value2");
//         MapPropertySource mapPropertySource =  new MapPropertySource("SecondInitializer",map);
//         environment.getPropertySources().addLast(mapPropertySource);
//        System.out.println("run SecondInitializer");
//
//    }
//}
