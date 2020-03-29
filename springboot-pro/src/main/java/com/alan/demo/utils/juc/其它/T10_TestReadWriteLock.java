package com.alan.demo.utils.juc.其它;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读写锁
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class T10_TestReadWriteLock {

//    static Lock lock = new ReentrantLock();

    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    /**
     * 读方法
     *
     * @param lock
     */
    public static void read(Lock lock) {

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 写方法
     */
    public static void write(Lock lock, int v) {

        lock.lock();
        try {
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        Runnable reader = () -> read(readLock);

        Runnable write = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < 18; i++) {
            new Thread(reader).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }
    }
}
