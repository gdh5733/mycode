package com.alan.demo.utils.juc.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 利用Callable实现线程   有返回值   (应用场景需要多线程处理有返回值得数据)
 * 主要用于多线程处理数据   最后算出返回值
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/2
 */

class myThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("--------------------call in callable-------------------- ");
        return 1024;
    }
}

public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //两个线程 , 一个main主线程 ,一个是AA futureTask

        //FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask = new FutureTask<>(new myThread());
        Thread t1 = new Thread(futureTask, "AA");
        t1.start();
        //int result02 = futureTask.get();

        System.out.println(Thread.currentThread().getName() + "******************");
        int result01 = 100;

//        while (!futureTask.isDone()) {
//
//        }

        int result02 = futureTask.get();//要求获得Callable线程的计算结果,如果没有计算完成就要去强求,会导致堵塞,值得计算完成
        System.out.println("********result: " + (result01 + result02));

    }

}
