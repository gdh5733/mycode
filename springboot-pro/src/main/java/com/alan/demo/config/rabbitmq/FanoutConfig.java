package com.alan.demo.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Fanout 交换机(广播)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */


@Configuration
public class FanoutConfig {

    //创建队列fanout.A
    @Bean(name = "Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    //创建队列fanout.B
    @Bean(name = "Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    //创建队列fanout.C
    @Bean(name = "Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    //配置广播路由器
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }


    //将fanout.A队列绑定到 fanoutExchange交换机
    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    //将fanout.B队列绑定到 fanoutExchange交换机
    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    //将fanout.C队列绑定到 fanout.C交换机
    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }


}
