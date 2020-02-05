package com.alan.demo.juc.并发容器;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Description 并发集合类不安全的问题  以及使用安全的并发容器
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
 * <p>
 * <p>
 * <p>
 * java.util.ConcurrentModificationException  并发修改异常
 * <p>
 * <p>
 * 1 故障现象
 * java.util.ConcurrentModificationException
 * 并发争抢修改导致,参考我们的花名册签名情况。
 * 一个人正在写入,另外一个同学过来抢夺,导致数据不一致异常。
 * <p>
 * <p>
 * 2 导致原因
 * <p>
 * <p>
 * 3 解决方案
 * 3.1 使用Vector 加锁
 * 3.2 Collections.synchronizedList(new ArrayList<>())
 * 3.3 List<String> list = new CopyOnWriteArrayList<>(); //写时复制
 * *
 * 4 优化建议(同样的错误不犯2次)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */

public class ContainerNotSafeDemo {


    //核心线程数
    private static final int CORE_POOL_SIZE = 100;
    //最大线程数
    private static final int MAX_POOL_SIZE = 120;

    //线程空闲时间
    private static final Long KEEP_ALIVE_TIME = 1L;
    //队列容量
    private static final int QUEUE_CAPACITY = 500;


    public static void main(String[] args) {


    }


    /**
     * 并发容器map不安全
     */
    private static void mapIsNotSafe() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //安全
        Map<String, String> map = new ConcurrentHashMap<>();

//安全        Map<String,String> map1 = Collections.synchronizedMap(map);
// 不安全       Map<String, String> map = new HashMap<>();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(() -> {
            map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
            System.out.println(map);
        });
        executor.shutdown();
    }

    /**
     * 并发容器set不安全
     */
    private static void setNotSafe() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //安全
        Set<String> set = new CopyOnWriteArraySet<>();


        //不安全
//        Set<String> set = new HashSet<>();


//安全        Set<String> set = Collections.synchronizedSet(new HashSet<>());


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(() -> {
            set.add(UUID.randomUUID().toString().substring(0, 8));
            System.out.println(set);
        });

        executor.shutdown();
    }

    /**
     * 并发容器list不安全
     */
    private static void listNotSafe() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //安全
        List<String> list = new CopyOnWriteArrayList<>();
        //不安全
//        List<String> list = new ArrayList<>();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(() -> {
            list.add(UUID.randomUUID().toString().substring(0, 8));
            System.out.println(list);
        });

        executor.shutdown();
    }
}
