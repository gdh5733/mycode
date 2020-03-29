package com.alan.demo.utils.juc.其它;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/8
 */

public class TickedSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号" + i);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null) {
                        break;
                    } else {
                        System.out.println("销售了--" + s);
                    }
                }
            }).start();
        }
    }

}
