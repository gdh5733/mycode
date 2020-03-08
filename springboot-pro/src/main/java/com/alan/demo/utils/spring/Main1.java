package com.alan.demo.utils.spring;

import com.alan.demo.utils.spring.Entity.Dept;
import com.alan.demo.utils.spring.Entity.Person;
import com.alan.demo.utils.spring.Entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Description 测试IOC  生命周期 注入方式  自动装配 都从这个主类学习 查看相应的配置文件即可
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

public class Main1 {

    public static void main(String[] args) {

        //初始化容器
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过getBean获取对象  通过setter 方法注入
        Student val1 = (Student) ac.getBean("test");
        System.out.println(val1);

        //通过getBean获取对象  通过构造方法 注入
        Student val2 = ac.getBean("test1", Student.class);
        System.out.println(val2);

        //使用工厂创建的bean
        Object o = ac.getBean("factory");
        System.out.println("输出的值为: " + o);


        //验证bean的自动装配
        Dept dept = (Dept) ac.getBean("dept");
        System.out.println("产生自动装配的结果: " + dept);

        //让主线程停一会
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //验证bean的生命周期
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
        ac.close();


        //bean的作用域  单例 多例 ..
        //若spring中有单例模式的bean,在初始化容器时就创建此对象,而多例即原型的bean，会在使用时创建


    }
}
