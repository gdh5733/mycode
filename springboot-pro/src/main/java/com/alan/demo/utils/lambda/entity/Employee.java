package com.alan.demo.utils.lambda.entity;
import lombok.*;

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
    private String age;
    private double salary;

    private Status status;

    public Employee(String name) {
        this.name = name;
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION;
    }
}
