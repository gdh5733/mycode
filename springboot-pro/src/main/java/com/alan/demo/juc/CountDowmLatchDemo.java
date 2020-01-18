package com.alan.demo.juc;

import com.alan.demo.utils.enums.ContryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Description CountDowmLatch demo 练习
 * <p>
 * 比如 六个同学 走完了之后  班长最后关门走人
 * <p>
 * 主要功能
 * 让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
 * CountDownLatch 主要有两个方法,当一个或多个线程调用await方法时,调用线程会被阻塞
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)
 * 当计数器的值变为零时,因调用await方法被阻塞的线程会被唤醒
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/10
 */

public class CountDowmLatchDemo {

    private static final int COUNT = 6;


    public static void main(String[] args) throws InterruptedException {
        closeDoor();
    }


    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        ContryEnum[] myArray = ContryEnum.values();
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习,离开教室");
                countDownLatch.countDown(); //数量减减  直到减为零  主线程执行
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t班长关门走人!");

    }
}
