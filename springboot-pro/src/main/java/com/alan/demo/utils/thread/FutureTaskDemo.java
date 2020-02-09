package com.alan.demo.utils.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 测试Callable接口类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("task return: " + task.get());
    }
}
