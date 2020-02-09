package com.alan.demo.utils.spring;

import com.alan.demo.utils.spring.AOP1.ArithmeticCalculator;
import com.alan.demo.utils.spring.AOP1.ArithmeticCalculatorImpl;
import com.alan.demo.utils.spring.AOP1.ArithmeticCalculatorLoggingProxy;

/**
 * @Description AOP1包代码的测试类  测试动态代理实现的AOP功能
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/28
 */

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();

        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();


        Object res = proxy.add(1, 2);

        System.out.println(res);

    }
}
