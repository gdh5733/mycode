package com.alan.demo.controller;

import com.alan.demo.entity.Cart;
import com.alan.demo.entity.CartPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description redis实现购物车简单逻辑
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */

@Slf4j
@RequestMapping("/redis-Cart")
@RestController
public class UserCartController {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 购物车key的前缀
     */
    public static final String CART_KEY = "cart:user:";


    /**
     * 添加购物车
     *
     * @param obj 购物车实体
     */
    @PostMapping(value = "/addCart")
    public void addCart(Cart obj) {

        String key = CART_KEY + obj.getUserId();

        Boolean hasKey = redisTemplate.opsForHash().getOperations().hasKey(key);

        //存在
        if (hasKey) {
            this.redisTemplate.opsForHash().put(key, obj.getProductId().toString(), obj.getAmount());
        } else {
            this.redisTemplate.opsForHash().put(key, obj.getProductId().toString(), obj.getAmount());
            this.redisTemplate.expire(key, 90, TimeUnit.DAYS);
        }

        // TODO: 2020/2/7 发rabbitmq 出去 
    }


    /**
     * 修改购物车数量
     *
     * @param obj 购物车实体
     */
    @PostMapping(value = "/updateCart")
    public void updateCart(Cart obj) {
        String key = CART_KEY + obj.getUserId();
        this.redisTemplate.opsForHash().put(key, obj.getProductId().toString(), obj.getAmount());

        // TODO: 2020/2/7  发rabbitmq 出去 
    }

    /**
     * 删除购物车
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    @PostMapping(value = "/delCart")
    public void delCart(Long userId, Long productId) {
        String key = CART_KEY + userId;
        this.redisTemplate.opsForHash().delete(key, productId.toString());

        // TODO: 2020/2/7 发rabbitmq 出去

    }


    /**
     * 查找购物车中的元素
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/findAll")
    public CartPage findAll(Long userId) {

        String key = CART_KEY + userId;
        CartPage cartPage = new CartPage();

        long size = this.redisTemplate.opsForHash().size(key);

        cartPage.setCount((int) size);

        Map<String, Integer> map = this.redisTemplate.opsForHash().entries(key);

        List<Cart> cartList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setProductId(Long.parseLong(entry.getKey()));
            cart.setAmount(entry.getValue());
            cartList.add(cart);
        }

        cartPage.setCartList(cartList);
        return cartPage;
    }
}
