package com.alan.demo.utils.spring.factoryBean;

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
public class Car {

    //汽车的品牌
    private String band;

    //价格
    private String price;
}
