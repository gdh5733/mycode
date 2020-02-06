package com.alan.demo.juc.死锁;

import java.util.concurrent.TimeUnit;

/**
 * @Description 模拟死锁 以及使用 jstack 命令分析死锁
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/10
 */

public class DeadLockDemo {

    private static Object resource1 = new Object();

    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {

            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }

        }, "线程1").start();


        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "waiting get resource1");

            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resopurce1");
            }
        }, "线程2").start();
    }
}
