package com.alan.demo.controller.redis;

import com.alan.demo.entity.CookieCart;
import com.alan.demo.service.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description 京东购物车cookie
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */
@Slf4j
@RequestMapping("/redis-Cookie")
@RestController
public class CookieCartController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private HttpServletResponse response;


    public static final String COOKIE_KEY = "cart:cookie:";


    /**
     * 添加购物车
     *
     * @param obj
     */
    @PostMapping(value = "addCart")
    public void addCart(CookieCart obj) {

        String cartId = this.getCookiesCartId();
        String key = COOKIE_KEY + cartId;
        Boolean haskey = redisTemplate.opsForHash().getOperations().hasKey(key);

        //存在
        if (haskey) {
            this.redisTemplate.opsForHash().put(key, obj.getProductId().toString(), obj.getAmount());
        } else {
            this.redisTemplate.opsForHash().put(key, obj.getProductId().toString(), obj.getAmount());
            this.redisTemplate.expire(key, 90, TimeUnit.DAYS);
        }
    }

    /**
     * 获取cookies
     *
     * @return
     */
    private String getCookiesCartId() {

        //第一步: 先检查cookies是否有cartid
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartId")) {
                    return cookie.getValue();
                }
            }
        }

        //第二步: cookies没有cartid，直接生成全局id,并设置到cookie里面
        //生成全局唯一id
        Long id = idGenerator.incrementId();

        //设置到cookies
        Cookie cookie = new Cookie("cartId", String.valueOf(id));
        response.addCookie(cookie);
        return id + "";
    }


    /**
     * 合并购物车
     * 把cookie中的购物车合并到登录用户的购物车
     *
     * @param userId
     */
    @PostMapping(value = "/mergeCart")
    public void mergeCart(Long userId) {


        //第一步: 提取未登录用户的cookie的购物车数据
        String cartId = this.getCookiesCartId();

        String keycookie = COOKIE_KEY + cartId;
        Map<String, Integer> map = this.redisTemplate.opsForHash().entries(keycookie);

        //第二步: 把cookie中得购物车合并到登录用户的购物车
        String keyuser = "cart:user:" + userId;
        this.redisTemplate.opsForHash().putAll(keyuser, map);

        //第三步: 删除redis未登录的用户cookies的购物车数据
        this.redisTemplate.delete(keycookie);

        //第四步: 删除未登录用户cookies的购物车数据
        Cookie cookie = new Cookie("cartId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

    }


}
