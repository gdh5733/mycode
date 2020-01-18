package com.alan.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description rabbit
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Configuration
public class RabbitConfig {

    public final static String QUERY = "queue";

    @Bean
    public Queue queue() {
        return new Queue(QUERY);
    }

}
