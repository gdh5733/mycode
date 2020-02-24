//package com.alan.demo.elasticsearch.rabbitmq;
//
//import com.alan.demo.config.DirectConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @Description 创建消费发送者
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2020/1/11
// */
//
//@Component
//@Slf4j
//public class RabbitSend {
//
//    @Autowired
//    AmqpTemplate amqpTemplate;
//
//
//    /**
//     * 使用direct交换器的方法发送
//     *
//     * @param msg 要发送的消息
//     */
//    public void directsend(String msg) {
//
//        log.info("消息发送之前");
//        /**
//         * 消息队列发送消息
//         * 参数一:  队列的名称
//         * 参数二:   消息
//         */
//        amqpTemplate.convertAndSend(DirectConfig.QUERY, msg);
//        log.info("消息已发送");
//    }
//
//    /**
//     * topic交换机发送
//     *
//     * @param msg 要发送的消息
//     */
//    public void topicsend(String msg) {
//        log.info("消息发送之前");
//        /**
//         * 参数一: 交换器名称
//         * 参数二: 路由键
//         * 参数三: 消息
//         */
//        amqpTemplate.convertAndSend("exchange", "topic.message", "Hello,Rabbit");
//    }
//
//
//    /**
//     * Headers and Fanout 类型的交换机 广播
//     *
//     * @param msg 要发送的消息
//     */
//    public void fanoutsend(String msg) {
//        log.info("发送消息前");
//        amqpTemplate.convertAndSend("fanoutExchange", "", "Hello,Rabbit!");
//    }
//}
