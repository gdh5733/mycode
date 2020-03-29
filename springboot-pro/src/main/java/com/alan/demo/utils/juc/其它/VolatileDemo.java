package com.alan.demo.utils.juc.其它;

import java.util.concurrent.TimeUnit;

/**
 * @Description 验证volatile的可见性
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/19
 */


//可操作资源类
class MyResoure {

    volatile int number = 0;


    public void add() {
        this.number = 60;
    }

}

/**
 * 验证volatile的可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyResoure myResoure = new MyResoure();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程开启!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myResoure.add();
            System.out.println("数值已经改为60");

        }, "AA").start();

        while (myResoure.number == 0) {

        }

        System.out.println("MISSON IS OVER!");
    }
}
