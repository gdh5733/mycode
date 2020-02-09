package com.alan.demo;

import com.alan.demo.utils.xml.HelloService;
import com.alan.demo.utils.xml.ann.MyBeanImport;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


//@ContextConfiguration(locations = "classpath:ioc/demo.xml")
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MyBeanImport.class)
class DemoApplicationTests {


    @Autowired
    private HelloService helloService;


//    @Autowired
//    private WeatherRunListener weatherRunListener;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void testEvent(){
//        weatherRunListener.rain();
//        weatherRunListener.snow();
//    }

    @Test
    public void testHello() {
        System.out.println(helloService.hello());
    }

}
