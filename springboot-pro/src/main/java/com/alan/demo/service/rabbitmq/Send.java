package com.alan.demo.service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/5
 */

@Component
public class Send {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg = "hello" + new Date();
        this.rabbitTemplate.convertAndSend("hello-alan-queue", msg);
    }
}
