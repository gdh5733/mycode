//package com.alan.demo.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//
///**
// * @Description 拦截类的编写
// * 定义了什么 时候干什么     www 中的 what when 还差一个where(PoinCut 切入点 及具体某个方法)
// *
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2019/12/25
// */
//
//@Aspect
//@Slf4j
//@Component
//public class RequestLogAspect {
//
//    @Autowired
//    private HttpServletRequest request; //自动注入request
//
////private static final Logger logger = (Logger) LoggerFactory.getLogger(RequestLogAspect.class);
//
//@Pointcut("execution(public * com.alan.demo.controller..*.*(..))")
//public void webLog(){}
//
//@Before("webLog()")
//public void doBefore(JoinPoint joinPoint){
////接受到请求,记录请求内容
//    log.info("URL :"+request.getRequestURL().toString());
//    log.info("IP :"+request.getRemoteAddr());
//}
//
//@AfterReturning(returning = "ret",pointcut = "webLog()")
//public void doAfterReturning(Object ret){
//   //处理完请求 , 返回内容
//    log.info("RESPONSE :"+ret);
//}
//}
