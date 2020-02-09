package com.alan.demo.utils.juc.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * CyclicBarrier 的字面意思是可循环使用(Cyclic)的屏障(Barrier)。
 * 它要做的事情是，让一组线程到达一个屏障(也可以叫同步点)时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，
 * 所有被屏障拦截的线程才会继续干活。CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，
 * 其参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。
 * <p>
 * <p>
 * 人到齐了才能开会
 * 集齐龙珠才能召唤神龙
 * </p>
 * CyclicBarrier的字面意识是可循环(Cyclic) 使用的屏障(Barrier)
 * 它要做的事情是,让一组线程到达一个屏障(也可以叫同步点) 时被阻塞,直到最后一个线程到达屏障时,屏障才会开门,
 * 所有被屏障拦截的线程才会继续干活,线程进入屏障通过CyclicBarrier的await()方法。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙!");
        });

        for (int i = 0; i < 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第: " + tempInt + "龙珠");
                try {
                    //先到的被阻塞
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
