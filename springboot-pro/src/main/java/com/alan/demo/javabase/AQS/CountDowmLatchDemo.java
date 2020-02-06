package com.alan.demo.javabase.AQS;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;


/**
 * @Description *  线程池操作CountDowmLatch
 * <p>
 * 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */

public class CountDowmLatchDemo {


    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch count = new CountDownLatch(10);

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(15);


        ExecutorService executor = new ThreadPoolExecutor(
                6,
                6,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            final int number = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(number + ": arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // TODO: 2020/2/6  to do something 

                        //运动员到达终点,count数减一
                        count.countDown();
                    }
                }
            });
        }
        System.out.println("Game Started");

        //等待count数变为0,否者会一直处于等待状态,游戏就没法结束了
        count.await();
        System.out.println("Game over");

        //关掉线程池
        executor.shutdown();
    }
}
