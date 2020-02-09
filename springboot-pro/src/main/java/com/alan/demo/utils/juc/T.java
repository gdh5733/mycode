package com.alan.demo.utils.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description volatile 并不能保证多个线程共同修改running变量时所带来的不一致问题,
 * 也就是说volatile不能替代synchronized
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class T {

    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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
}
