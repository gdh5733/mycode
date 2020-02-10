package com.alan.demo.service.rabbitmq;

import com.alan.demo.config.DirectConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消息接收者
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Component
@Slf4j
public class RabbitRevice {

    /**
     * 接受消息的方法.采用消息队列监听机制
     *
     * @param msg
     */
    @RabbitListener(queues = DirectConfig.QUERY)
    public void recive(String msg) {
        log.info("接受消息{}", msg);

    }

}
