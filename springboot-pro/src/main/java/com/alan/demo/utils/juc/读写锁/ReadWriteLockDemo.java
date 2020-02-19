package com.alan.demo.utils.juc.读写锁;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读写锁
 * 首先启动读线程，此时number为0；然后某个时刻写线程修改了共享资源number数据，读线程再次读取最新值！
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/19
 */

public class ReadWriteLockDemo {


    public static void main(String[] args) throws InterruptedException {
        ReadWrite rwd = new ReadWrite();
        //启动100个读线程
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.get();
                }
            }, "Read").start();
        }

        //写线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwd.set((int) (Math.random() * 101));
            }
        }, "Write").start();

    }
}

class ReadWrite {
    //模拟共享资源--Number
    private int number = 0;
    // 实际实现类--ReentrantReadWriteLock，默认非公平模式
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读
    public void get() {
        //使用读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    //写
    public void set(int number) {
        readWriteLock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}


