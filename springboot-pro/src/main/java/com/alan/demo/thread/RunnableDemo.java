package com.alan.demo.thread;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class RunnableDemo {

    public static void main(String[] args) {
        MyRunnable m1 = new MyRunnable("Runnable1");
        MyRunnable m2 = new MyRunnable("Runnable2");
        MyRunnable m3 = new MyRunnable("Runnable3");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
    }
}
