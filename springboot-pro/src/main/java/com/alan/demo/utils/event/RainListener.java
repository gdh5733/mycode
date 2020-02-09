package com.alan.demo.utils.event;

import org.springframework.stereotype.Component;

/**
 * @Description  下雨事件监听器
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent){
            System.out.println("hello "+event.getWeather());
        }
    }
}
