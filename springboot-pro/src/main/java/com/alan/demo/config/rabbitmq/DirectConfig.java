package com.alan.demo.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description rabbit  配置文件 (创建消息队列)
 *
 * <p> direct 交换器   即type = direct
 *
 * <p>在项目启动的时候,就把队列创建好
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */

@Configuration
public class DirectConfig {

    /**
     * 队列的名字
     */
    public final static String QUERY = "direct-queue";


    /**
     * 创建队列
     *
     * @return
     */
    @Bean(name = "directqueue")
    public Queue queue() {
        return new Queue(QUERY);
    }

}
