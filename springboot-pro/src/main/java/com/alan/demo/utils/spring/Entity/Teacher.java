package com.alan.demo.utils.spring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

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

    //老师的名字
    private String name;

    //老师教的班级
    private List<String> cls;

    //老师的上级领导
    private Map<String, String> bossMap;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }
}
