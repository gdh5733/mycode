package com.alan.demo.entity;

import lombok.Data;

/**
 * @Description 购物车Entity
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */

@Data
public class Cart {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long productId;


    /**
     * 数量
     */
    private int amount;
}
