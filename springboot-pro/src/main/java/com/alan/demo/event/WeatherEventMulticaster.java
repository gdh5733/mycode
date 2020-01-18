package com.alan.demo.event;

import org.springframework.stereotype.Component;

/**
 * @Description  天气事件广播器
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public class WeatherEventMulticaster  extends  AbstractEventMulticaster{

    //开始广播
    @Override
    void doStart() {
        System.out.println("begin broadcast weather event");
    }

    //结束广播
    @Override
    void doEnd() {
        System.out.println("end broadcast weather event");
    }
}
