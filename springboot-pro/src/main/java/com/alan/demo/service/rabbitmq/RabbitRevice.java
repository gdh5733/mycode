//package com.alan.demo.service.rabbitmq;
//
//import com.alan.demo.config.rabbitmq.DirectConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Description 消息接收者
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2020/2/10
// */
//@Component
//@Slf4j
//public class RabbitRevice {
//    /**
//     * 接受消息的方法.采用消息队列监听机制
//     *
//     * @param msg
//     */
//    @RabbitListener(queues = DirectConfig.QUERY)
//    public void recive(String msg) {
//        log.info("接受消息{}", msg);
//
//    }
//
//    @RabbitListener(queues = "topic.message")
//    public void process(String str) {
//        System.out.println("ReceiverA  : " + str);
//    }
//
//    @RabbitListener(queues = "topic.message")
//    public void process2(String str) {
//        System.out.println("ReceiverB  : " + str);
//    }
//
//    @RabbitListener(queues = "fanout.A")
//    public void process3(String str) {
//        System.out.println("ReceiverA  : " + str);
//    }
//
//    @RabbitListener(queues = "fanout.B")
//    public void process4(String str) {
//        System.out.println("ReceiverB  : " + str);
//    }
//
//    @RabbitListener(queues = "fanout.C")
//    public void process5(String str) {
//        System.out.println("ReceiverC  : " + str);
//    }
//
//}
