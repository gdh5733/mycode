package com.alan.demo.javabase.pooldemo;

import java.util.Date;

/**
 * @Description 一个简单的线程池demo: Runnable + ThreadPoolExecutor
 * <p>
 * 这是一个简单的Runnable类,需要大约5分钟来执行其任务
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/5
 */

public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private  void processCommand() {

        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "  waiting finished.....................");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
