package com.alan.demo.utils.juc.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 手写自旋锁
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */

public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in O(n_n)O");

        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnLock()");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            //暂停一会线程
            try {

                spinLockDemo.myLock();
                TimeUnit.SECONDS.sleep(5);
                spinLockDemo.myUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        }, "BB").start();

    }
}
