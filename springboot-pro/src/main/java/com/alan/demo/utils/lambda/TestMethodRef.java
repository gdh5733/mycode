package com.alan.demo.utils.lambda;
import com.alan.demo.utils.lambda.entity.Employee;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Description 方法引用: 若Lambda 体中的内容有方法已经实现了,我们可以使用方法引用
 * <p>
 * 主要有第三种语法格式:
 * <p>
 * 对象::实例方法名
 * <p>
 * 类::静态方法名
 * <p>
 * 类::实例方法名
 * <p>
 * 注意:
 * 1.Lambda 体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表和放回值类型保持一致
 * 2.若 Lambda 参数列表中的第一个参数 是实例方法的调用者,而第二个方法是实例方法的参数时,可以使用ClassName :: method
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/20
 */

public class TestMethodRef {


    //类::实例方法名
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        boolean val = bp.test("5", "6");

    }


    //类::静态方法名
    public void test3() {

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
        int val = com1.compare(2, 3);
    }


    //对象::实例方法名
    public void test1() {
        PrintStream ps1 = System.out;
        Consumer<String> con = (x) -> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.print(num);
    }
}
