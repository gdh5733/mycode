package com.alan.demo.iocContain.ioc;

import lombok.Data;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */
@Data
public class Car {

    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;

}
