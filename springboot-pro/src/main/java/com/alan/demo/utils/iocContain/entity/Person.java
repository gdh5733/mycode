package com.alan.demo.utils.iocContain.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/25
 */

@Data
@Component
public class Person {
    @Value("1")
    private Long id;
    @Value("Jack")
    private String name;

    @Autowired
    public Pet pet;

    public void Call(){
        pet.move();
    }
}
