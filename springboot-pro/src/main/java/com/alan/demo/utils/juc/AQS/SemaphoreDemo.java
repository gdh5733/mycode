package com.alan.demo.utils.juc.AQS;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description Semaphore  的主要作用是协调对有限资源(公共资源)的访问
 *
 * <p>
 * 抢车位 比如说 6个汽车 抢占三个车位
 * (通过信号量Semaphore来控制 --> 主要通过发放许可证的方式)
 *
 * </p>
 *
 * <p>
 * semaphore有一个许可证的概念，在我们创建semaphore的时候，可以指定该semaphore中的许可证permit的总数量。
 *
 * </p>
 *
 * <p>
 * 假定Semaphore总共有N个permits，那么acquire()方法会为当前线程获取一个许可证,这时Semaphore中总共可用的许可证就少一个。还剩下N-1个。
 * 只有获取了许可证的线程才允许执行。
 * </p>
 *
 * <p>
 *  Semaphore.acquire()方法：  可能获取许可证成功，也可能获取许可证失败。
 * 1.如果获取许可证成功，那么当前线程就有了运行的许可。
 * 2.如果获取许可证失败，那么当前线程就会被阻塞住。处于Waiting状态，并不断自旋获取锁，只有在获取许可证成功的情况下，才能运行，否则将一直阻塞住。
 * </p>
 *
 * <p>
 * <p>
 *  一个线程获取了许可证，当用完之后，就需要释放，Semaphore提供了release()方法来释放一个许可证：
 * semaphore.release()方法会使：
 * 1.semaphore中可用的许可证数增加。
 *
 * </p>
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

public class SemaphoreDemo {


    public static void main(String[] args) {
        //模拟三个停车位  参数33 相当于拥有的许可证
        Semaphore semaphore = new Semaphore(33);

        //模拟六部汽车
        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                try {
                    //占到车位 (即当前线程获得到了许可证)
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放车位(即当前线程释放许可证)
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
