package com.alan.demo.utils.reflect;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */

public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = Robot.class.getClassLoader();
        Class r = Class.forName("com.alan.demo.utils.reflect.Robot");
    }
}
