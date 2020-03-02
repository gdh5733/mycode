package com.alan.demo.utils.juc.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 使用Lock 实现 三个线程 按顺序打印    A线程 5次 B线程 10次  C线程 15   打印10轮
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

/**
 * 资源类
 */
class ShareResource {

    private int number = 1;//定义标识位

    private Lock lock = new ReentrantLock();

    public Condition c1 = lock.newCondition();

    public Condition c2 = lock.newCondition();

    public Condition c3 = lock.newCondition();


    /**
     * 打印五次
     */
    public void print5() {
        lock.lock();
        try {

            //判断
            while (number != 1) {
                c1.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;//改变标志位
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印十次
     */
    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                c2.await();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印十五次
     */
    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                c3.await();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


public class SynAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }


}
