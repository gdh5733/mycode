package com.alan.demo.event;

/**
 *天气监听器
 */
public interface WeatherListener {
    void onWeatherEvent(WeatherEvent event);
}
