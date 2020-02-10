package com.alan.demo.controller.rabbitmq;

import com.alan.demo.service.rabbitmq.RabbitSend;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试rabbitmq的使用 自己搭建的RabbitMQ Server
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Api(description = "rabbit相关接口")
@RestController
@Slf4j
public class RabbitMQController {

    @Autowired
    RabbitSend rabbitSend;

    /**
     * 登录场景
     */
    @ApiOperation(value = "发送消息", notes = "发送消息")
    @GetMapping(value = "/login")
    public String login() {
        //用户信息
        String body = "id:" + 1 + "name:" + "admin";
        rabbitSend.send(body);
        return "登录成功!";
    }




}
