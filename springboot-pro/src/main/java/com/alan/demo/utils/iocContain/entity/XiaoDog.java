package com.alan.demo.utils.iocContain.entity;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/25
 */

@Component
public class XiaoDog implements Pet {
    @Override
    public void move() {
        System.out.println("running");
    }
}
