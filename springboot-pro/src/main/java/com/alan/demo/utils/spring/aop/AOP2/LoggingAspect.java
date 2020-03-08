//package com.alan.demo.utils.spring.aop.AOP2;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Description
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2020/1/28
// */
//
////把这个类声明为一个切面: 需要把该类放入到IOC容器中,在声明为一个切面
//@Aspect
//@Component("LoggingAspect1")
//public class LoggingAspect {
//
//
//    /**
//     * 声明该方法是一个前置通知: 在目标方法开始之前执行
//     *
//     * @param joinPoint
//     */
//    @Before("execution(public int com.alan.demo.utils.spring.aop.AOP2.ArithmeticCalculatorImpl.add(int,int))")
//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method " + methodName + "begins with " + args);
//    }
//
//    /**
//     * 后置通知: 在目标方法执行后(无论是否发生异常),执行的通知
//     * 在后置通知中还不能访问目标方法执行的结果
//     *
//     * @param joinPoint
//     */
//    @After("execution(* com.alan.demo.utils.spring.aop.AOP2.ArithmeticCalculatorImpl.*.*(int,int))")
//    public void afterMethod(JoinPoint joinPoint) {
//
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + "ends");
//    }
//
//
//}
