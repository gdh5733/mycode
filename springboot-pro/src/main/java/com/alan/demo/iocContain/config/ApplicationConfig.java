package com.alan.demo.iocContain.config;

import com.alan.demo.iocContain.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 本类告诉springIOC 容器如何装配Person类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/25
 */

@Configuration
public class ApplicationConfig {

//    @Bean(name="person")
//    public Person initPerson(){
//        Person user = new Person();
//        user.setId(1L);
//        user.setName("Jack");
//        return user;
//    }
}
