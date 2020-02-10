package com.alan.demo.service.rabbitmq;

import com.alan.demo.config.DirectConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description 创建消费发送者
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Component
@Slf4j
public class RabbitSend {

    @Autowired
    AmqpTemplate amqpTemplate;


    /**
     * 发送消息的方法
     *
     * @param msg 要发送的消息
     */
    public void send(String msg) {

        log.info("消息发送之前");
        /**
         * 消息队列发送消息
         * 参数一:  队列的名称
         * 参数二:   消息
         */
        amqpTemplate.convertAndSend(DirectConfig.QUERY, msg);
        log.info("消息已发送");

    }
}
