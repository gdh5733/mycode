package com.alan.demo.utils.juc;

import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description FutureTask 即是一个Task  也是一个Future
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0k
 * @Date 2020/1/9
 */

public class T06_00_Future {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            TimeUnit.SECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());//阻塞

    }
}
