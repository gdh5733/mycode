package com.alan.demo.utils.spring.AOP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/28
 */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) context.getBean("ArithmeticCalculatorImpl");

        arithmeticCalculator.add(2, 3);

        arithmeticCalculator.mul(3, 4);
    }
}
