package com.alan.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.alan.demo"})
@MapperScan({"com.alan.demo.mapper"})
@SpringBootApplication
@EnableRabbit
public class DemoApplication {


    public static void main(String[] args) throws InterruptedException {


        SpringApplication.run(DemoApplication.class, args);


//       ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
//      Person person = ctx.getBean(Person.class);
//        System.out.println("Name is "+person.getName());
//        person.Call();


//像springboot容器当中注册系统初始化容器的第二种方式
//       SpringApplication springApplication = new SpringApplication(DemoApplication.class);
//       springApplication.addInitializers(new SecondInitializer());
//              springApplication.run(args);

//像springboot容器中注册监听器第二种方式
//        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
//        springApplication.addListeners(new SecondListener());
//        springApplication.run();


//springboot计时器
//        StopWatch myWatch = new StopWatch();
//        myWatch.start("task1");
//        Thread.sleep(2000);
//        myWatch.stop();
//
//        myWatch.start("task2");
//        Thread.sleep(3000);
//        myWatch.stop();
//        myWatch.start("task3");
//        Thread.sleep(1000);
//        myWatch.stop();
//        System.out.println(myWatch.prettyPrint());



    }

}
