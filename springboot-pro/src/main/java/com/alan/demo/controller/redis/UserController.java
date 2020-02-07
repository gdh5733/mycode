package com.alan.demo.controller.redis;

import com.alan.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */


@Slf4j
@RestController
@RequestMapping("/redis-user")
public class UserController {

    Map<String, User> userMap = new HashMap<>();


    public UserController() {
        User u1 = new User(1, "alan1", "alan1");

        userMap.put("alan1", u1);

        User u2 = new User(2, "alan2", "alan2");

        userMap.put("alan2", u2);

    }


    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/find/{username}")
    public User find(@PathVariable String username) {
        User user = this.userMap.get(username);
        log.info("通过用户名={},查找出用户{}", username, user);
        return user;

    }

}
