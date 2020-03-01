package com.alan.demo.utils.juc.读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读写锁
 * <p>
 * 多个线程同时读一个资源类没有任何问题,所以为了满足并发量,读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来,就不应该再有其它线程可以对该资源进行读或写
 * 小总结:
 * <p>
 * 读 -读能共存
 * 读 -写不能共存
 * 写-写不能共存
 * <p>
 * 写操作: 原子+独占,整个过程必须是一个完整的统一体,中间不许被分割,被打断
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/1
 */

//资源类
class Mycache {


    volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void put(String key, Object value) {

        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入: " + key);
            //暂停一会线程
            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成: ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) {

        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取: " + key);

            //暂停一会线程

            TimeUnit.SECONDS.sleep(2);

            Object result = map.get(key);

            System.out.println(Thread.currentThread().getName() + "\t 读取完成: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

}

public class ReadWriteLock {

    public static void main(String[] args) {
        Mycache mycache = new Mycache();

        //写
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                mycache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        //读
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                mycache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
