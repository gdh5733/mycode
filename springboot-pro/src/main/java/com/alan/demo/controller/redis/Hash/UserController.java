package com.alan.demo.controller.redis.Hash;

import com.alan.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

        //初始化2个用户,用于模拟登录
        User u1 = new User(1, "alan1", "alan1");

        userMap.put("alan1", u1);

        User u2 = new User(2, "alan2", "alan2");

        userMap.put("alan2", u2);

    }


    @GetMapping(value = "/login")
    public String login(String username, String password, HttpSession session) {
        //模拟数据库的查找
        User user = this.userMap.get(username);
        if (user != null) {
            if (!password.equals(user.getPassword())) {
                return "用户名或密码错误";
            } else {
                session.setAttribute(session.getId(), user);
                log.info("登录成功{}", user);
            }
        } else {
            return "用户名或密码错误";
        }
        return "登录成功！！！";
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


    /**
     * 拿当前用户的session
     *
     * @return
     */
    public String session(HttpSession session) {
        log.info("当前用户的session={}", session.getId());
        return session.getId();
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        log.info("退出登录session={}", session.getId());
        session.removeAttribute(session.getId());
        return "成功退出";
    }
}
