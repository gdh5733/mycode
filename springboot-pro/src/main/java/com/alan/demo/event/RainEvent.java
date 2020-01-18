package com.alan.demo.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

public class RainEvent extends WeatherEvent {

    @Override
    public String getWeather() {
        return "rain";
    }
}
