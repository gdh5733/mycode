package com.alan.demo.spring.AOP3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/28
 */

@Aspect
@Component
public class LoggingAspect {

    /**
     * com.alan.demo.spring.AOP3.ArithmeticCalculator  接口的每一个实现类的每一个方法开始之前执行一段代码
     */


    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("execution(public int com.alan.demo.spring.AOP3.ArithmeticCalculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + name + "begins" + args);
    }


    /**
     * 后置通知(在方法执行之后执行的代码,无论该方法是否出现异常)
     *
     * @param joinPoint
     */
    @After("execution(public int com.alan.demo.spring.AOP3.ArithmeticCalculator.*(..))")
    public void AfterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + name + "begins" + args);
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值
     *
     * @param joinPoint
     */
    @AfterReturning(value = "execution(public int com.alan.demo.spring.AOP3.ArithmeticCalculator.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + name + "begins" + args + result);
    }

    /**
     * 异常通知
     * (在目标方法出现异常时会执行的代码,可以访问到异常对象;
     * 且可以执行在出现特定异常时在执行通知代码
     * )
     *
     * @param joinPoint
     * @param Ex
     */
    @AfterThrowing(value = "execution(public int com.alan.demo.spring.AOP3.ArithmeticCalculator.*(..))",
            throwing = "Ex")
    public void afterThrowing(JoinPoint joinPoint, Exception Ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "occurs excetion:" + Ex);
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint 类型的参数,
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值,返回值即为目标方法的返回值
     *
     * @param pjd
     */
    @Around("execution(public int com.alan.demo.spring.AOP3.ArithmeticCalculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methName = pjd.getSignature().getName();

        //执行目标方法
        try {
            //前置通知
            System.out.println("The method " + methName + "begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //后置通知
            System.out.println("The method ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method occurs exception: " + e);
            throw new RuntimeException(e);
        }

        //后置通知
        System.out.println("The method " + methName + "ends");
        return result;
    }

}
