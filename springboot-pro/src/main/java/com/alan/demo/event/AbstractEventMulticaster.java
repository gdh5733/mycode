package com.alan.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

@Component
public abstract class AbstractEventMulticaster implements EventMulticaster{

    @Autowired
    private List<WeatherListener> listenerList;

    /**
     * 广播事件
     * @param event
     */
    @Override
    public void multicastEvent(WeatherEvent event) {
        doStart();
        listenerList.forEach(i->{
            i.onWeatherEvent(event);
        });
        doEnd();
    }

    //添加监听器
    @Override
    public void addListener(WeatherListener weatherListener) {
        listenerList.add(weatherListener);
    }

    //删除监听器
    @Override
    public void removeListener(WeatherListener weatherListener) {
       listenerList.remove(weatherListener);
    }
    abstract void doStart();
    abstract void doEnd();
}
