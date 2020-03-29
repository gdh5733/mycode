package com.alan.demo.utils.juc.其它;

import java.util.concurrent.TimeUnit;

/**
 * @Description synchronized 本身就是可从入锁的一种
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class T01_ReentrantLock1 {

    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) {
                m2();
            }
        }

    }

    synchronized void m2() {
        System.out.println("m2...");
    }


    public static void main(String[] args) {
        T01_ReentrantLock1 r1 = new T01_ReentrantLock1();
        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //不再可重入锁 或者在m1方法中调用m2这个线程将会被阻塞执行
//        new Thread(r1::m2).start();

    }
}


