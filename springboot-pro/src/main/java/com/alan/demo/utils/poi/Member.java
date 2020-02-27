package com.alan.demo.utils.poi;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/26
 */


//创建一个实体对象,用来存储到excel表中
@Setter
@Getter
public class Member {


    private Integer code;
    private String name;
    private Integer age;
    private Date birth;


    public Member(Integer code, String name, Integer age, Date birth) {
        super();
        this.code = code;
        this.name = name;
        this.age = age;
        this.birth = birth;

    }
}
