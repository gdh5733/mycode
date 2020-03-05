package com.alan.demo.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/5
 */

@Component
public class Receiver {

    @RabbitListener(queues = "hello-alan-queue")
    public void process(String msg) {
        System.out.println("receiver: " + msg);
    }

}
