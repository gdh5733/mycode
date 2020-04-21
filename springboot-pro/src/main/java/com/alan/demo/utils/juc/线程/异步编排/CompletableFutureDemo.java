package com.alan.demo.utils.juc.线程.异步编排;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description CompletableFutureDemo 异步编排
 * <p>
 * Future 接口可以构建异步应用,但依然有其局限性,它很难直接表述多个Future 结果之间的依赖性,
 * 实际开发中,我们经常需要达成以下目的:
 * <p>
 * 1.将多个异步计算的结果合并成一个
 * 2.等待Future结果集合中的所有任务都完成
 * 3.Future完成事件(即,任务完成以后触发执行动作)
 * 4.创建CompletableFuture
 * * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/24
 */

public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println("主线程......");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程开始: " + Thread.currentThread());
            String uuid = UUID.randomUUID().toString();
            System.out.println("当前线程结束: " + Thread.currentThread());
            return uuid;

        }, pool).thenApply((r) -> {
            System.out.println("上一步的结果是: " + r);
            return r.replace("-", "");
        }).whenComplete((r, e) -> {
            System.out.println("最终的结果是" + r);
            System.out.println("输出异常信息" + e);
        });

        System.out.println("主线程结束......" + future.get());
    }
}
