package com.alan.demo.utils.gc.强软弱虚引用;

import java.lang.ref.WeakReference;

/**
 * @Description 弱引用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class WeakReferenceDemo {

    public static void main(String[] args) {

        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("=======");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
