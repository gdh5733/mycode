package com.alan.demo.utils.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 测试Callable接口类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

@Slf4j
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            log.info("task has not finished,please wait!");
        }
        log.info("task return:{}", task.get());
    }
}
