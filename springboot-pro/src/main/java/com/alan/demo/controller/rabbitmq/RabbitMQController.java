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
     * 使用direct交换机发送
     */
    @ApiOperation(value = "使用direct交换机发送", notes = "发送消息")
    @GetMapping(value = "/directsend")
    public String directsend() {
        //用户信息
        String body = "id:" + 1 + "name:" + "admin";
        rabbitSend.directsend(body);
        return "使用direct交换机发送消息成功!";
    }


    /**
     * 使用topic交换机发送
     *
     * @return
     */
    @ApiOperation(value = "使用topic交换机发送", notes = "发送消息")
    @GetMapping(value = "/topicsend")
    public String topicsend() {
        //用户信息
        String body = "id:" + 1 + "name:" + "admin";
        rabbitSend.topicsend(body);
        return "使用topic交换机发送消息成功!";

    }

    @ApiOperation(value = "使用fanoutsend交换机发送", notes = "发送消息")
    @GetMapping(value = "/fanoutsend")
    public String fanoutsend() {
        //用户信息
        String body = "id:" + 1 + "name:" + "admin";
        rabbitSend.fanoutsend(body);
        return "使用Headers and Fanout交换机发送消息成功!";
    }

}
