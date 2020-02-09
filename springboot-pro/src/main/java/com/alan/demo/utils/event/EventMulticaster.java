package com.alan.demo.utils.event;

/**
 * 定义广播器接口
 */
public interface EventMulticaster {
    //广播器广播事件
    void multicastEvent(WeatherEvent event);
    //允许添加监听器
    void addListener(WeatherListener weatherListener);
    //允许删除监听器
    void removeListener(WeatherListener weatherListener);
}
