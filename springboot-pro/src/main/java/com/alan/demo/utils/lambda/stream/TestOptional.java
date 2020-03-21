package com.alan.demo.utils.lambda.stream;
import com.alan.demo.utils.lambda.entity.Employee;
import java.util.Optional;
/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/21
 */

public class TestOptional {

    /*

       Optional 容器类的常用方法:
       Optional.of(T t): 创建一个Optional 实例
       Optional.empty(): 创建一个空的Optional 实例
       Optional.ofNullable(T t): 若t不为null,创建Optional实例,否则创建空的实例
       isPresent(): 判断是否包含值
       orElse(T t): 如果调用对象包含值,返回该值,否则返回t
       orElseGet(Supplier s): 如果调用对象包含值,返回该值,否则返回s获取的值
       map(Function f):如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
       flatMap(Function mapper):与map类似,要求返回值必须是Optional

     */


    public void test3() {
//        Optional<Employee> op = Optional.ofNullable(new Employee());
        Optional<Employee> op = Optional.ofNullable(null);

        //如果不为空
        if (op.isPresent()) {
            System.out.println(op.get());
        }

        //如果调用对象包含值,返回该值,否则返回t
        Employee emp = op.orElse(new Employee("张三", "18", 888.8, Employee.Status.FREE));
        System.out.println(emp);


        Employee employee = op.orElseGet(() -> new Employee());
        System.out.println(employee);


        Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str2.get());
    }


    public void test2() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());

    }


    public void test1() {

        Optional<Employee> op = Optional.of(new Employee());

        //快速锁定空指针异常
//        Optional<Employee> op = Optional.of(new Employee());


        Employee emp = op.get();
        System.out.println(emp);

    }

}
