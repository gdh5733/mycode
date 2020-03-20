package com.alan.demo.utils.lambda.stream;
import com.alan.demo.utils.lambda.entity.Employee;
import java.util.ArrayList;
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

public class TestStreamAPI1 {


    //创建Stream
    public void test1() {


        //1.可以通过Collection 系列集合提供的stream() 或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();


        //2.通过Arrays 中的静态方法stream() 获取数组流
        Employee[] emp = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emp);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");


        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);

        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

    }
}
