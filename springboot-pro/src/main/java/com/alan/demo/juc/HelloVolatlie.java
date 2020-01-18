package com.alan.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Description Volatile
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/6
 */

public class HelloVolatlie {

    //对比以下有无volatile的情况下,整个程序运行结果的区别
    volatile boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end!");
    }


    /**
     * 程序主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        HelloVolatlie t = new HelloVolatlie();
        new Thread(t::m, "t1").start();

        try {

            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
