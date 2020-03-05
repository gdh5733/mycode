package com.alan.demo.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 创建队列
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/5
 */

@Configuration
public class SenderConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello-alan-queue");
    }
}
