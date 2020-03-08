//package com.alan.demo.utils.spring.aop.AOP2;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @Description 测试AspectJ基于xml 配置的AOP
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2020/1/28
// */
//
//public class Main {
//    public static void main(String[] args) {
//        //1. 创建Spring 的IOC 容器
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2. 从IOC容器中 获取bean的实例
//        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("ArithmeticCalculatorImpl");
//
//
//        //3. 使用bean
//        int res = arithmeticCalculator.add(3, 6);
//
//        System.out.println("result:" + res);
//    }
//}
