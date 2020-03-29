package com.alan.demo.utils.juc.其它;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description CAS 无锁优化 或者称作自旋
 * Automic类(原子的)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class T01_AtomicInterger {

    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T01_AtomicInterger t = new T01_AtomicInterger();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> {
            o.start();
        });

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);

    }
}
