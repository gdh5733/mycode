package com.alan.demo.utils.bean.spring;

import com.alan.demo.utils.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */

public class main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springbean.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

    }

}
