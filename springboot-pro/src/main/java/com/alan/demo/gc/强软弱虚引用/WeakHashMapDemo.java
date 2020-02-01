package com.alan.demo.gc.强软弱虚引用;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class WeakHashMapDemo {


    public static void main(String[] args) {
        myHashMap();
        System.out.println("=============");
        myWeakHashMap();
    }

    /**
     * WeakHashMap 弱引用
     * <p>
     * 弱引用 一但gc触发   就会被回收
     */
    private static void myWeakHashMap() {

        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    /**
     * HashMap 实现的强引用
     */
    private static void myHashMap() {

        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
