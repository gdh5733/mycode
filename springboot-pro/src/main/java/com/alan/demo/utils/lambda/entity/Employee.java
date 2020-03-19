package com.alan.demo.utils.lambda.entity;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private int age;
    private double salary;
}
