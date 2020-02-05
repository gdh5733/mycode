package com.alan.demo.utils.设计模式.策略模式解决ifelse;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 需求
 * 这里虚拟一个业务需求，让大家容易理解。
 * 假设有一个订单系统，里面的一个功能是根据订单的不同类型作出不同的处理。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

@Data
public class OrderDTO {


    private String code;

    private BigDecimal price;

    /**
     * 订单类型
     * 1:普通订单
     * 2:团购订单
     * 3:促销订单
     */
    private String type;

}
