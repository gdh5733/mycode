package com.alan.demo.utils.spring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

@Setter
@Getter
@ToString
public class Student {

    public String name;

    public String age;


    public Teacher teacher;

    public Student() {
    }

    public Student(String name, String age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

}
