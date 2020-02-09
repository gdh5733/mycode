package com.alan.demo.utils.juc.可重入锁;

/**
 * @Description 可重入锁   就是说某个线程已经获得某个锁,可以再次获取锁而不会出现死锁
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/6
 */

public class WhatReentrant {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁,这个锁是: " + this + "线程名称是: " + Thread.currentThread().getName());
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this + "线程名称是: " + Thread.currentThread().getName());
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}
