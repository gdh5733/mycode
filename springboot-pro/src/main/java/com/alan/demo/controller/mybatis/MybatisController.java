package com.alan.demo.controller.mybatis;
import com.alan.demo.entity.Users;
import com.alan.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description Mybatis 采用NoSQL形式  实现增删改查
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
            this.usersService.createUsers(user);
        }
    }

    @RequestMapping(value = "/u/{id}", method = RequestMethod.GET)
    public void update(@PathVariable int id) {
        Users user = new Users();
        user.setId(id);
        String temp = "user" + id;
        user.setUsername(temp);
        user.setPassword(temp);
        this.usersService.updateUsers(user);
    }


    @RequestMapping(value = "/f", method = RequestMethod.GET)
    public void find() {
        this.usersService.findExample();
    }

}
