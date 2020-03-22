package com.alan.demo.utils.juc.同步工具;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 两个线程
 * 第一个线程需要 从1到26  第二个线程需要从A到Z  交替打印 顺序输出  (多种方法实现)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/8
 */

public class T02_00_LockSupport {

    static Thread t1 = null, t2 = null;

    /*给自定以自旋锁使用*/
    enum ReadyToRun {T1, T2}

    /*给自定义自旋锁使用*/
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        m1();//使用LockSupport 方法实现
    }


    /**
     * 使用LockSupport方法实现
     */
    private static void m1() {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.println(c);
                LockSupport.unpark(t2);//叫醒T2
                LockSupport.park();//T1阻塞
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.unpark(t2);//t2阻塞
                System.out.println(c);
                LockSupport.unpark(t1);//叫醒t1
            }
        }, "t2");
    }

    /**
     * 使用synchronized wait() notify() 实现
     */
    private static void m2() {
        final Object obj = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : aI) {
                    System.out.println(c);
                    try {
                        obj.notify();
                        obj.wait();//释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();//因为最后总有一个线程是阻塞的状态
            }
        }, "t1").start();


        new Thread(() -> {
            synchronized (obj) {
                for (char c : aC) {
                    System.out.println(c);
                    try {
                        obj.notify();
                        obj.wait();//释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "t2").start();

    }

    /**
     * 使用Condition多个等待队列实现
     */
    private static void m3() {

        char[] aT = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        Lock lock = new ReentrantLock();

        Condition conditionT1 = lock.newCondition();

        Condition conditionT2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {

                for (char c : aT) {
                    System.out.println(c);
                    conditionT2.signal();
                    conditionT1.await();
                }
                conditionT2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();


        new Thread(() -> {
            lock.lock();
            try {

                for (char c : aC) {
                    System.out.println(c);
                    conditionT1.signal();
                    conditionT2.wait();
                }
                conditionT1.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    /**
     * 使用自定以自旋锁的方式实现
     */
    public void m4() {

        char[] aT = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aT) {
                while (r != ReadyToRun.T1) {
                }
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (r != ReadyToRun.T2) {
                }
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();

    }
}
