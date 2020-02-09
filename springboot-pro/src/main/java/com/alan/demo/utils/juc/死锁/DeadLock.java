package com.alan.demo.utils.juc.死锁;


class HoldLockThread implements Runnable {

    private String lockA;

    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有:" + lockA + "\t 尝试获得" + lockB);

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有:" + lockB + "\t 尝试获得" + lockA);
            }
        }
    }
}


/**
 * @Description 死锁是指两个或两个以上的进程在执行过程中
 * 因争夺资源而造成的一种互相等待的现象,
 * 入无外力干涉那它们都将无法推进下去
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/30
 */


public class DeadLock {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();

        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();

        /**
         * Linux ps -ef|grep   ls -l
         * window下的java运行程序 也有类似ps的查看进程的命令,但是目前我们需要查看的只是java
         * jps = java ps     jps -l
         *
         * 然后jstack 线程ID    查看堆栈信息
         */

    }
}

