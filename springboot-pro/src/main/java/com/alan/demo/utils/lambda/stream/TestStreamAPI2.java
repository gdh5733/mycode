package com.alan.demo.utils.lambda.stream;
import com.alan.demo.utils.lambda.entity.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/20
 */

public class TestStreamAPI2 {


    List<Employee> list = Arrays.asList(

            new Employee("a", "18", 9999.99,Employee.Status.FREE),
            new Employee("b", "38", 5555.99,Employee.Status.FREE),
            new Employee("c", "50", 8888,Employee.Status.FREE),
            new Employee("d", "16", 8888,Employee.Status.FREE),
            new Employee("e", "8", 8888,Employee.Status.FREE)
    );

    //中间操作

    /*
      排序
      sorted()-自然排序(Comparable)
      sorted(Comparator)--定制排序(Comparator)
     */


    public void test7() {
        list.stream()
                .sorted((x, y) -> {
                    if (x.getName().equals(y.getName())) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return x.getAge().compareTo(y.getAge());
                    }
                }).forEach(System.out::println);
    }





    /*
      映射
      map-接收Lambda,将元素转换成其他形式或提取信息.接收一个函数作为参数,该函数会被用到每一个元素上,并将其映射成一个新的元素。
      flatMap-接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有的流连接成一个流
     */


    /**
     * 删选与切片
     * filter-接收Lambda,从流中排除某些元素.
     * limit-截断流,使其元素不超过给定数量
     * skip(n) -跳过元素,返回一个扔掉了前n个元素的流,若流中元素不足n个,则返回一个空流,与limit(n) 互补
     * distinct-筛选,通过流所生成元素的hashCode() 和equals() 去除重复元素
     */


    //distinct去重
    public void test5() {
        list.stream()
                .filter((x) -> x.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------------------------------");
        list.stream()
                .map((x) -> x.getName())
                .forEach(System.out::println);
    }

    //skip跳过前两个
    public void test4() {
        list.stream()
                .filter((x) -> x.getSalary() > 5000)
                .skip(2)
                .forEach(System.out::println);
    }


    //limit取前两个
    public void test3() {
        list.stream()
                .filter((x) -> x.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }

    //内部迭代: 迭代操作由Stream API 完成
    public void test1() {

//        //中间操作 不会执行任何操作
//        Stream<Employee> stream = list.stream()
//                .filter((x) -> x.getAge() > 35);
//
//        stream.forEach(System.out::println);
//
//        //终止操作: 一次性执行全部内容,即"惰性求值"
//        stream.forEach(System.out::println);
    }
}
