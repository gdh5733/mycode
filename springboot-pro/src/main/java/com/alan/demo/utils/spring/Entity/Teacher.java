package com.alan.demo.utils.spring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
public class Teacher {

    private String name;

    private List<String> cls;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }
}
