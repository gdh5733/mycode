package com.alan.demo.gc.强软弱虚引用;

import java.lang.ref.SoftReference;

/**
 * @Description 软引用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class SoftReferenceDemo {


    /**
     * 内存够用的时候就保留,不够用就回收
     */
    public static void SoftRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * 内存不够用的时候 就回收
     * <p>
     * JVM配置,故意产生大对象并配置小的内存,让它内存不够用了导致OOM,看软引用的回收情况
     * -Xms5m -Xmx5m -XX:PrintGCDetails
     * </p>
     */
    public static void SoftRef_Memory_NotEnough() {
        Object o2 = new Object();
        SoftReference<Object> softReference1 = new SoftReference<>(o2);
        System.out.println(o2);
        System.out.println(softReference1.get());

        o2 = null;
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o2);
            System.out.println(softReference1.get());
        }
    }


    public static void main(String[] args) {
//        SoftRef_Memory_Enough();
//        SoftRef_Memory_NotEnough();

    }

}


