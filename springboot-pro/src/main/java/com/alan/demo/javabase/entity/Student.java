package com.alan.demo.javabase.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */
@Data
@Setter
@Getter
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

}
