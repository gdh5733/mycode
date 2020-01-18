package com.alan.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author gaodehan 通过线程池来获取线程的消息
 * 好处是 当多个任务提交给线程池的时候  便于并发的统一管理
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future future = newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("task has not finished,please wait!");
        }
        System.out.println(future.get());
        newCachedThreadPool.shutdown();
    }
}
