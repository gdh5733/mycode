package com.alan.demo.utils.设计模式.观察者;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 观察者模式 (个人理解就是 一个方法有变化了  其他的方法跟着变)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/6
 */


//事件源(这个孩子)
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类
@Setter
@Getter
class wakeUpEvent {
    //发生时间
    long timestamp;

    //发生地点
    String loc;

    public wakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }

}


//观察者接口
interface Observer {
    void actionOnWakeUp(wakeUpEvent event);
}


//具体父亲观察者
class Dad implements Observer {

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        if (!"bed".equals(event.getLoc())) {
            System.out.println("爸爸哄着.....");
        }
    }
}

//具体母亲观察者
class Mom implements Observer {

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        if ("bed".equals(event.getLoc())) {
            System.out.println("妈妈哄着...");
        }
    }

}

public class Main {

    public static void main(String[] args) {

        Child child = new Child();
        if (!child.isCry()) {
            child.wakeUp();
        }
    }

}
