package com.alan.demo.utils.spring;

import com.alan.demo.utils.spring.Entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试IOC
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

public class Main1 {

    public static void main(String[] args) {

        //初始化容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过getBean获取对象  通过setter 方法注入
        Student val1 = (Student) ac.getBean("test");
        System.out.println(val1);

        //通过getBean获取对象  通过构造方法 注入
        Student val2 = ac.getBean("test1", Student.class);
        System.out.println(val2);

    }
}
