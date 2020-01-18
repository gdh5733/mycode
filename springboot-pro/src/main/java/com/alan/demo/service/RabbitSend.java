package com.alan.demo.service;

import com.alan.demo.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description 创建生产者
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Component
public class RabbitSend {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     */
    public void send(String msg) {

        while (true) {
            System.out.println(RabbitConfig.QUERY + "发送" + msg + "之前");
            amqpTemplate.convertAndSend(RabbitConfig.QUERY, msg);
            System.out.println(RabbitConfig.QUERY + "发送" + msg);
        }

    }
}
