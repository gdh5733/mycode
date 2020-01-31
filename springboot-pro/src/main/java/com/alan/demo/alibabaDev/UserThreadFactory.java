package com.alan.demo.alibabaDev;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 线程池 以及线程池的拒绝策略 (阿里巴巴java开发)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */

public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称,在使用jstack来排查线程问题时,非常有帮助
    UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "--Worker--";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0, false);
        System.out.println(thread.getName());
        return thread;
    }
}

//执行任务
class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}

//拒绝策略
class UserRejectHandler implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("tasked rejected. " + executor.toString());
    }
}

//用户线程池
class UserThreadPool {
    public static void main(String[] args) {
        //缓存队列设置固定长度为2,为了快速触发rejectHandler
        BlockingQueue queue = new LinkedBlockingDeque(2);

        //假设外部任务线程的来源由机房1和机房2的混合调用
        UserThreadFactory f1 = new UserThreadFactory(" 第一机房 ");
        UserThreadFactory f2 = new UserThreadFactory(" 第二机房 ");

        UserRejectHandler handler = new UserRejectHandler();

        //核心线程数为1,最大线程数为2,为了保证触发rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

        //创建400个任务线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }

}
