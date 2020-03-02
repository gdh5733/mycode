package com.alan.demo.utils.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class ReentrantLockTest2 {

    //默认参数为false 是非公平锁   写上参数true为公平锁
    private static final Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
        new Thread(() -> test(), "线程C").start();
        new Thread(() -> test(), "线程D").start();
        new Thread(() -> test(), "线程E").start();

    }

    /**
     * 验证公平锁
     */
    public static void test() {
        //循环两次加锁和放锁
        for (int i = 0; i < 2; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
