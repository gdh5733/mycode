package com.alan.demo.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @Description
 * <p>
 * 1.队列
 * 2.阻塞队列
 * 2.1 阻塞队列有没有好的一面
 * <p>
 * 2.2 不得不阻塞,你如何管理
 *
 * </p>
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

public class BlockingQueueDemo {


    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));


        blockingQueue.remove();

    }

}
