package com.alan.demo.iocContain.ioc;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class SimpleIOCTest {

    public static void main(String[] args) throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("spring-test.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }

}
