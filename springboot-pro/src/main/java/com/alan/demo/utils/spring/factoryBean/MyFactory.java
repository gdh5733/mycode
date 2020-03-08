package com.alan.demo.utils.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description 通过FactoryBean来获取Car
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

public class MyFactory implements FactoryBean<Car> {


    /**
     * 获取汽车对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBand("奥迪");
        car.setPrice("20000");
        return car;
    }


    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
