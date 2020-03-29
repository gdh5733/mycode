package com.alan.demo.utils.juc.其它;

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

public class ReentrantLockTest3 {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));
        thread.start();
        thread1.start();
        thread.interrupt();//第一个线程中断


    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
//                firstLock.lockInterruptibly();
//                TimeUnit.MILLISECONDS.sleep(50);
//                secondLock.lockInterruptibly();

                if (!lock1.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(10);
                }
                if (!lock2.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源 正常结束");
            }
        }
    }
}
