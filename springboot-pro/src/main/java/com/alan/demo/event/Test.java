package com.alan.demo.event;

/**
 * @Description 测试监听器模式
 * 要素
 * 1.事件
 * 2.监听器
 * 3.广播器
 * 4.触发机制
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

public class Test {
    public static void main(String[] args) {
        //定义一个广播器
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();

        //雨天监听器
        RainListener rainListener = new RainListener();

        //雪天监听器
        SnowListener snowListener = new SnowListener();

        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);
        //下雪事件
        SnowEvent snowEvent = new SnowEvent();
        //下雨事件
        RainEvent rainEvent = new RainEvent();

        eventMulticaster.multicastEvent(snowEvent);
        eventMulticaster.multicastEvent(rainEvent);
//        eventMulticaster.removeListener();

    }
}
