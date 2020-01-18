package com.alan.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description 淘宝多线程  面试题实现一个容器 提供两个方法add,size 写两个线程
 * 线程1 --> 添加10个元素到容器中
 * 线程2 --> 实时监控元素个数,当个数到5个时,线程2给出提示并结束
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/8
 */

public class T03_NotifyHoldingLock {


    volatile List list = new ArrayList();


    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T03_NotifyHoldingLock c = new T03_NotifyHoldingLock();
        final Object obj = new Object();
        //注意先启动t2在启动t1
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("t2 启动");
                if (c.size() != 5) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //t2执行结束  唤醒t1继续执行
                obj.notify();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {

            synchronized (obj) {
                System.out.println("t1 启动");
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5) {
                        //notify能够唤醒线程 但是并不释放锁
                        obj.notify();

                        try {
                            //释放锁 让t2得以执行
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 结束");
            }

        }, "t1").start();
    }
}
