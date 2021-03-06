package com.alan.demo.utils.javabase;


import java.util.concurrent.*;

/**
 * @Description 讲一下 synchronized 关键字的底层原理
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class SynchronizedDemo {

    /**
     * ① synchronized 同步语句块的情况
     */
    public static void method() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("synchronized 代码块");
        }
    }

    /**
     * ② synchronized 修饰方法的的情况
     */
    public static synchronized void method1() {
        System.out.println("synchronized 方法");
    }

    public static void main(String[] args) {


        for (int i = 0; i < 3; i++) {

            ExecutorService executorService = new ThreadPoolExecutor(
                    1,
                    2,
                    1L,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    SynchronizedDemo.method1();
                }
            });

            //关闭线程池
            executorService.shutdown();

        }
    }

}
