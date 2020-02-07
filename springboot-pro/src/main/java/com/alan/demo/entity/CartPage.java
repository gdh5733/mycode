package com.alan.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description 购物车列表
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */

@Data
public class CartPage<T> {

    private List<T> cartList;

    private int count;
}
