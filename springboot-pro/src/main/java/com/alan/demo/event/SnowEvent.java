package com.alan.demo.event;

/**
 * @Description  下雪事件
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

public class SnowEvent extends WeatherEvent {

    @Override
    public String getWeather() {
        return "snow";
    }
}
