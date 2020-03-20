package com.alan.demo.utils.lambda.stream;

import com.alan.demo.utils.lambda.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

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


    List<Employee> employeeList = Arrays.asList(

            new Employee("a", "18", 9999.99, Employee.Status.FREE),
            new Employee("b", "35", 5555.99, Employee.Status.BUSY),
            new Employee("c", "50", 6666.99, Employee.Status.VOCATION),
            new Employee("d", "16", 3333.33, Employee.Status.FREE),
            new Employee("e", "8", 7777.77, Employee.Status.BUSY)
    );


    /*
     收集
     collect-将流转换为其它形式,接收一个Collector接口实现,用于给Stream中元素做汇总的方法
     */


    //多级分组 先按状态分组 在按年龄分组
    public void test7() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((x) -> {
                    if (x.getAge().equals("35")) {
                        return "青年";
                    } else if (x.getAge().equals("50")) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
    }


    //分组 按照状态分组
    public void test6() {
        Map<Employee.Status, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        map.forEach((k, v) -> {
            System.out.println("键值为:" + k + " 值为:" + v);
        });

    }


    public void test5() {
        //总数
        Long count = employeeList.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("---------------------------------------");

        //平均值
        Double avg = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //总和
        Double sum = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //最大值
        Optional<Employee> max = employeeList.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

    }

    public void test4() {
        List<String> list = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("------------------------");

        Set<String> set = employeeList.stream()
                .map(Employee::getAge)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);
        System.out.println("----------------------");

        HashSet<String> hs = employeeList.stream()
                .map(Employee::getAge)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

    }

    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("------------------------");
        Optional<Double> op = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());

    }


    public void test2() {
        Long count = employeeList.stream()
                .count();
        System.out.println(count);

        Optional<Employee> emp = employeeList.stream().max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        System.out.println(emp.get());

        Optional<Double> op2 = employeeList.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);

        System.out.println(op2.get());

    }

    public void test1() {
        boolean bl = employeeList.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl);


        boolean bl1 = employeeList.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl1);

        boolean bl2 = employeeList.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(bl2);

        Optional<Employee> op = employeeList.stream()
                .findFirst();
        System.out.println(op.get());


        Optional<Employee> op1 = employeeList.stream()
                .filter((employee -> employee.getStatus().equals(Employee.Status.FREE)))
                .findAny();
        System.out.println(op1.get());

    }
}
