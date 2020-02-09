package com.alan.demo.utils.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public class WeatherRunListener {

    @Autowired
    private WeatherEventMulticaster eventMulticaster;

    //调用雪的监听器
    public void  snow(){
        eventMulticaster.multicastEvent(new SnowEvent());

    }

    //调用雨的监听器
    public void rain(){
        eventMulticaster.multicastEvent(new RainEvent());
    }
}
