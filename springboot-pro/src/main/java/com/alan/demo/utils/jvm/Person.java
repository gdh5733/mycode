package com.alan.demo.utils.jvm;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/23
 */

@Setter
@Getter
public class Person {


    private String name;


    public Person(String name) {
        this.name = name;
    }
}
