package com.alan.demo.utils.juc.阻塞队列;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * 非同步阻塞队列
 *
 * @Description 当阻塞队列是空时, 从队列中获取元素的操作将会被阻塞。
 * 当阻塞队列是满的时候,往队列里添加元素的操作将会被阻塞
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
        ArrayBlockingQueueMeth();

    }

    private static void ArrayBlockingQueueMeth() {
        //有界队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        //无界队列
        BlockingQueue<String> blockingQueue1 = new LinkedBlockingDeque<>();

        //像队列中加入值
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("x"));

        //看一下队列的第一个元素
        System.out.println("探测顶端元素" + blockingQueue.peek());

        System.out.println("取出元素 " + blockingQueue.poll());
        System.out.println("取出元素 " + blockingQueue.poll());
        System.out.println("取出元素 " + blockingQueue.poll());
        System.out.println("取出元素 " + blockingQueue.poll());
        System.out.println("取出元素 " + blockingQueue.poll());


//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));


//        blockingQueue.remove();


//        try {
//
//            //阻塞
//            blockingQueue.put("a");
//            blockingQueue.put("a");
//            blockingQueue.put("a");
//            blockingQueue.put("a");
//
//            blockingQueue.take();
//            blockingQueue.take();
//            blockingQueue.take();
//            blockingQueue.take();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }



}
