package com.alan.demo.utils.compare;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 定制排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/12
 */

public class CompareTest {

    /**
     * Comparator接口的使用
     * 1.背景:
     * 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码,
     * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作,
     * 那么可以考虑使用Comparator的对象排序
     * 2.重写compare(Object,Object)方法,比较o1和o2的大小:\
     * 如果方法返回正整数,则表示o1大于o2;
     * 如果返回0,表示相等;
     * 返回负整数,表示o1小于o2。
     */


    @Setter
    @Getter
    @ToString
    class Car {
        int age;
        String band;
    }

    public void test2() {
        Car car = new Car();
        car.setAge(10);
        car.setBand("奥迪");

        Car car1 = new Car();
        car1.setAge(30);
        car1.setBand("保时捷");

        Car car2 = new Car();
        car2.setBand("奔驰");

        List<Car> val = new ArrayList<>();
        val.add(car);
        val.add(car1);
        val.add(car2);

        //注意该处用到的是Comparator 而不是Compareable
        Collections.sort(val, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(val);
    }
}
