package com.alan.demo.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 集合类不安全的问题
 * 笔记
 * 1.最好用写时复制来解决ArrayList add数据的时候 照成的不安全  List<String> list = new CopyOnWriteArrayList<>();
 * 往一个容器添加元素的时候,不直接往当前容器Object[]添加,而是先将当前容器Obejct[]进行Copy,复制出一个新的容器Obejct[] newElements
 * 然后新的容器Object[] newElments里添加元素,添加完元素之后,再将原容器的引用指向新的容器 setArray(newElements); 这样做的好处是
 * 可以对CopyOnWrite容器进行迸发的读,而不需要加锁,因为当前容器不会添加任何元素,所以CopyOnWrite容器也是一种读写分离的思想,读和写不同的容器
 * <p>
 * <p>
 * <p>
 * public boolean add(E e) {
 * synchronized (lock) {
 * Object[] elements = getArray();
 * int len = elements.length;
 * Object[] newElements = Arrays.copyOf(elements, len + 1);
 * newElements[len] = e;
 * setArray(newElements);
 * return true;
 * }
 * }
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */

public class ContainerNotSafeDemo {

    public static void main(String[] args) {


    }

    private static void mapIsNotSafe() {
        Map<String, String> map = new HashMap<>();//不安全
//        Map<String, String> map = Collections.synchronizedMap();//安全
//        Map<String, String> map = new ConcurrentHashMap<>();//安全
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new HashSet<>();//不安全
//安全        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//安全        Set<String> set = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException  并发修改异常
        /**
         *
         * 1 故障现象
         *        java.util.ConcurrentModificationException
         *      并发争抢修改导致,参考我们的花名册签名情况。
         *      一个人正在写入,另外一个同学过来抢夺,导致数据不一致异常。
         *
         *
         * 2 导致原因
         *
         *
         * 3 解决方案
         *    3.1 使用Vector 加锁
         *    3.2 Collections.synchronizedList(new ArrayList<>())
         *    3.3 List<String> list = new CopyOnWriteArrayList<>(); //写时复制
         *
         * 4 优化建议(同样的错误不犯2次)
         *
         */}


}
