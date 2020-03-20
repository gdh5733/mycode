package com.alan.demo.utils.lambda.stream;

import com.alan.demo.utils.lambda.entity.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/20
 */

public class TestStreamAPI3 {


    public static void main(String[] args) {
        TestStreamAPI3 testStreamAPI3 = new TestStreamAPI3();
        testStreamAPI3.test1();
        testStreamAPI3.test2();
    }

    /*
    查找与匹配
    allMatch-检查是否匹配所有元素
    anyMatch-检查是否至少匹配一个元素
    noneMatch-检查是否没有匹配元素
    findFirst-返回第一个元素
    findAny-返回当前流的任意元素
    count-返回流中元素的总个数
    max-返回流中的最大值
    min-返回流中的最小值
     */


    List<Employee> list = Arrays.asList(

            new Employee("a", "18", 9999.99, Employee.Status.FREE),
            new Employee("b", "38", 5555.99, Employee.Status.BUSY),
            new Employee("c", "50", 6666.99, Employee.Status.VOCATION),
            new Employee("d", "16", 3333.33, Employee.Status.FREE),
            new Employee("e", "8", 7777.77, Employee.Status.BUSY)
    );


    public void test2() {
        Long count = list.stream()
                .count();
        System.out.println(count);

        Optional<Employee> emp = list.stream().max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        System.out.println(emp.get());

        Optional<Double> op2 = list.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);

        System.out.println(op2.get());

    }

    public void test1() {
        boolean bl = list.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl);


        boolean bl1 = list.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl1);

        boolean bl2 = list.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl2);

        Optional<Employee> op = list.stream()
                .findFirst();
        System.out.println(op.get());


        Optional<Employee> op1 = list.stream()
                .filter((employee -> employee.getStatus().equals(Employee.Status.FREE)))
                .findAny();
        System.out.println(op1.get());

    }
}
