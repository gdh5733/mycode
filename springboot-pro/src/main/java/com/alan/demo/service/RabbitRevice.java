package com.alan.demo.service;

import com.alan.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description 创建接收者
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Component
public class RabbitRevice {

    /**
     * 接受消息
     *
     * @param msg
     */
    @RabbitListener(queues = RabbitConfig.QUERY)
    public void recive(String msg) {
        System.out.println("好啊," + msg);
    }

}
