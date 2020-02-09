package com.alan.demo.utils.juc;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Description 自定义
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/9
 */

public class T05_00_HelloThreadPool {


    static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read(); //就是阻塞线程
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }

    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 8; i++) {
            tpe.execute(new Task(i));
        }

        System.out.println(tpe.getQueue()); //查看阻塞队列中的数据值
        tpe.execute(new Task(100));//线程数不够了主线程 main会执行
        tpe.shutdown();
    }

}
