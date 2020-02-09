package com.alan.demo.utils.thread;

import lombok.SneakyThrows;

/**
 * @Description 验证sleep和wait的最主要的本质区别
 * sleep会抱着锁睡觉 不会释放锁 (即让出CPU 不释放锁)
 * waith会让出CPU也
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class WaitSleepDemo {

    public static void main(String[] args) {

        final Object lock = new Object();
        //开辟第一个线程
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread A get lock");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread A do wait method");
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread A is done");
                }
            }
        }).start();

        //保证第一个线程先执行
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开辟第二个线程
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread B do wait method");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


}
