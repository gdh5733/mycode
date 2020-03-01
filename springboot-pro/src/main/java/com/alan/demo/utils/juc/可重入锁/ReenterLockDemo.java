package com.alan.demo.utils.juc.可重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 可重入锁 落地实现
 * synchronized  和 ReentrantLock 都是可重入锁
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/1
 */


//资源类
class Phone {

    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS()");
        sendEmail();
    }

    private synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t ######invoked sendEmail()");
    }


    public void get() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS()");

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        System.out.println(Thread.currentThread().getId() + "\t ######invoked sendEmail()");
    }

}

public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            //线程操作资源类
            phone.sendSMS();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            //线程操作资源类
            phone.sendSMS();
        }, "B").start();

        System.out.println("-----------------------------以上是synchronized实现的可重入锁----------------------------------");


        System.out.println("-----------------------------以下是ReentrantLock实现的可重入锁---------------------------------");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {

            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "C").start();
    }
}


