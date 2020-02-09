package com.alan.demo.utils.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/6
 */

public class Sync1 {
    static Object obj = new Object();


    public static void main(String[] args) {


        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
