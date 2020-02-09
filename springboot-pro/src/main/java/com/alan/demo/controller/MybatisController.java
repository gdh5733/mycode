package com.alan.demo.controller;

import com.alan.demo.entity.Users;
import com.alan.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */


@Slf4j
@RequestMapping("/mybatis-users")
@RestController
public class MybatisController {


    @Autowired
    private UsersService usersService;

    /**
     * 初始化1000条数据
     */
    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public void create() {
        for (int i = 0; i < 1000; i++) {
            Users user = new Users();
            String temp = "user" + i;
            user.setUsername(temp);
            user.setPassword(temp);
            Random random = new Random();

            //0-1 随机选取一个
            int sex = random.nextInt(2);
            user.setSex((byte) sex);
            usersService.createUsers(user);
        }
    }
}
