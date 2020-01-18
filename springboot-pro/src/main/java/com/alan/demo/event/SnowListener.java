package com.alan.demo.event;

import org.springframework.stereotype.Component;

/**
 * @Description 下雪的监听器
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent){
            System.out.println("hello "+event.getWeather());
        }
    }
}
