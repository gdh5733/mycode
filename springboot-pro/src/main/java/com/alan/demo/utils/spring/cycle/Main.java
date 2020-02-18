package com.alan.demo.utils.spring.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试springbean的生命周期
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");

        Car car = (Car) ctx.getBean("car");

        System.out.println(car);

        //关闭容器
        ctx.close();

    }
}
