package com.alan.demo.utils.javabase.AQS;

/**
 * @Description 需要在线程池中执行的任务
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */

public class MyRunnable implements Runnable {


    private int command;

    private int i = 0;


    public MyRunnable(int s) {
        this.command = s;
    }

    @Override
    public void run() {
        synchronized (MyRunnable.class) {
            System.out.println("线程:" + Thread.currentThread().getName() + i);
            i++;
        }
    }


    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                ", i=" + i +
                '}';
    }
}
