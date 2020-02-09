package com.alan.demo.utils.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 3.0版本  阻塞队列
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

/***
 * 资源
 */
class MyRescource {

    Logger logger = LoggerFactory.getLogger(getClass());
    private volatile boolean FLAG = true;//默认开启, 进行生产+消费

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyRescource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        logger.info(blockingQueue.getClass().getName());
    }

    /**
     * 生产者
     *
     * @throws Exception
     */
    public void myProd() throws Exception {
        String data;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了,表示flag=false,生产动作结束");
    }

    /**
     * 消费者
     *
     * @throws Exception
     */
    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒钟没有取出蛋糕,消费退出");
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列蛋糕" + result + "成功");
        }


    }

    public void stop() throws Exception {
        this.FLAG = false;
    }

}


public class ProdConsumer_BlockQueueDemo {


    public static void main(String[] args) throws Exception {
        MyRescource myRescource = new MyRescource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myRescource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myRescource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        //暂停一会线程
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println();
            System.out.println();
            System.out.println();
            myRescource.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
