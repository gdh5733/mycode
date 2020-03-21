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

public class TestStreamAPI {


    List<Employee> list = Arrays.asList(

            new Employee("a", "18", 9999.99, Employee.Status.FREE),
            new Employee("b", "38", 5555.99, Employee.Status.FREE),
            new Employee("c", "50", 8888, Employee.Status.FREE),
            new Employee("d", "16", 8888, Employee.Status.FREE),
            new Employee("e", "8", 8888, Employee.Status.FREE)
    );


    /**
     * 1.给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?
     * 给定【1，2，3，4，5】,应该返回【1，4，9，16，25】
     */

    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    /**
     * 2.怎样用map和reduce方法数一数流中有多少个Employee呢?
     */

    public void test2() {
        Optional<Integer> count = list.stream()
                .map((x) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }


}
