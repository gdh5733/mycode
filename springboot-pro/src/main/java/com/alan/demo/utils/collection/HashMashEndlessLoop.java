package com.alan.demo.utils.collection;

import java.util.HashMap;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */

public class HashMashEndlessLoop {

    private static HashMap<Long, EasyCoding> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }, "线程" + i).start();
        }
    }
}

class EasyCoding {

}
