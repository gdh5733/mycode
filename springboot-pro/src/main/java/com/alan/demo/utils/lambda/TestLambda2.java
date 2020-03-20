package com.alan.demo.utils.lambda;
import com.alan.demo.utils.lambda.entity.Employee;
import com.alan.demo.utils.lambda.myinterface.Myfun;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * 一.Lambda 表达式的基础语法: Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或Lambda 操作符
 * 箭头操作符 Lambda 表达式拆分成两部分:
 * <p>
 * 左侧: Lambda 表达式的参数列表
 * 右侧: Lambda 表达式中所需执行的功能,即 Lambda 体
 * <p>
 * 语法格式一:无参数,无返回值
 * ()->System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二: 有一个参数,并且无返回值
 * (x)->System.out.print(x)
 * 语法格式三:若只有一个参数,小括号可以省略不写
 * x->System.out.println(x)
 * <p>
 * 语法格式四:有两个以上的参数,有返回值,并且Lambda 体中有多条语句
 * Comparator<Integer> com = (x,y)->{
 * <p>
 * System.out.print("函数式接口");
 * return Integer.compare(x,y);
 * }
 * <p>
 * 语法格式五: 若Lambda 体中只有一条语句,return 和大括号都可以省略不写
 * <p>
 * <p>
 * 二.lambda 表达式需要函数式接口的支持
 * 函数式接口: 接口中只有一个抽象方法的接口,称为函数式接口,可以使用注解@FunctionalInterface 修饰
 * 可以检查是否是函数式接口
 *
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/20
 */

public class TestLambda2 {


    List<Employee> list = Arrays.asList(

            new Employee("a", 18, 9999.99),
            new Employee("b", 38, 5555.99),
            new Employee("c", 50, 6666.99),
            new Employee("d", 16, 3333.33),
            new Employee("e", 8, 7777.77)
    );


    //调用Collections.sort()方法,通过定制排序比较两个Employee(先按年龄比,年龄相同按姓名比),使用 Lambda 作为参数传递
    public void test4() {
        Collections.sort(list, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        TestLambda2 testLambda2 = new TestLambda2();
        testLambda2.test2();
        testLambda2.test3();
    }


    public void test2() {

        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("this is var");

    }

    public void test3() {
        Integer val = operation(100, (x) -> x + 200);
        System.out.println("函数式计算之后" + val);
    }

    public Integer operation(Integer num, Myfun mf) {
        return mf.getValue(num);
    }

}
