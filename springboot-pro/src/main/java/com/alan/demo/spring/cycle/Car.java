package com.alan.demo.spring.cycle;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class Car {

    public Car() {
        System.out.println("Car's Constructor...");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destory() {
        System.out.println("destory...");
    }
}
