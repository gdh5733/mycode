package com.alan.demo.ioc.xml.xml;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public class Bird extends Animal {
    @Override
    public String getName() {
        return "bird";
    }
}
