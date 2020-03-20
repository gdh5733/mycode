package com.alan.demo.utils.lambda;
import com.alan.demo.utils.lambda.entity.Employee;
import com.alan.demo.utils.lambda.myinterface.MyPredict;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */

public class TestLambda {


    List<Employee> list = Arrays.asList(

            new Employee("a", "18", 9999.99,Employee.Status.FREE),
            new Employee("b", "38", 5555.99,Employee.Status.FREE),
            new Employee("c", "50", 6666.99,Employee.Status.FREE),
            new Employee("d", "16", 3333.33,Employee.Status.FREE),
            new Employee("e", "8", 7777.77,Employee.Status.FREE)
    );


    //原来的匿名内部类

    public void test1() {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }


    //Lambda 表达式
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }


    //需求: 获取当前公司中员工年龄大于35的员工信息
    public static List<Employee> filterEmployees(List<Employee> list, MyPredict<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : emps) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public static void main(String[] args) {


    }


    //lambda优化
    private void lambda1() {

        filterEmployees(list, e -> e.getSalary() <= 5000);
    }

    //stream优化
    private void lambda2() {
        list.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        //取出集合中对象的名字
        List<String> val = list.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

    }

}
