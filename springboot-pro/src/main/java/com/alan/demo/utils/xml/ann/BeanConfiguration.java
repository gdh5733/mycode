package com.alan.demo.utils.xml.ann;

import com.alan.demo.utils.xml.xml.Animal;
import com.alan.demo.utils.xml.xml.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 像容器中注册方式一  bean注解注入
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/21
 */

@Configuration
public class BeanConfiguration {

    @Bean("dog")
    Animal getDog() {
        return new Dog();
    }
}
