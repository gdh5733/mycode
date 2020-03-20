package com.alan.demo.utils.lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/**
 * @Description Java内置的四大核心函数式接口
 * <p>
 * Consumer<T> : 消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>: 供给型接口
 * T get();
 * <p>
 * Function<T,R>: 函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/20
 */

public class TestLambda3 {


    //Predicate<T> 断言型接口:

    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");

        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }


    //需求: 将满足条件的字符串,放入到集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> stringList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                stringList.add(str);
            }
        }
        return stringList;
    }

    //Function<T,R> 函数型接口:
    public void test3() {
        String newStr = strHandler(" 去除前后的空格  ", (x) -> x.trim());
        String subStr = strHandler(" 截取字符串aaaaaaa ", (str) -> str.substring(2, 5));
        System.out.println(newStr);
        System.out.println(subStr);
    }


    //需求: 用于处理字符串
    public String strHandler(String str, Function<String, String> fup) {
        return fup.apply(str);
    }


    //Consumer<T> 消费型接口
    public void test1() {
        happpy(10000, (m) -> System.out.println("consume " + m + "元"));
    }

    public void happpy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    // Supplier<T>: 供给型接口
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) Math.random() * 100);
        for (Integer num : numList) {
            System.out.println(num);
        }
    }


    //需求: 产生一些数,并放入到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }
}
