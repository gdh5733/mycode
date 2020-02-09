package com.alan.demo.utils.thread;

import java.util.concurrent.Callable;

/**
 * @Description 测试Callable接口
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
