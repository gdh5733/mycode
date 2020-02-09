package com.alan.demo.utils.javabase.AQS;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Description CyclicBarriar + 线程池     结合Future Callable 有反回值 来查看线程工作状态
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/6
 */

public class CyclicBarriarDemo {

    public static void main(String[] args) throws Exception {
        CyclicBarriarDemo demo = new CyclicBarriarDemo();
        System.out.println("Future、Callable有返回值，get()阻塞串行 开始============================================================");
        demo.alibabaThreadPool2();
//        System.out.println("Future Callable支持返回,并行 开始============================================================");
//        demo.alibabaThreadPool3();
//        System.out.println("CyclicBarrier、Runnable同时并行 开始============================================================");
//        demo.alibabaThreadPool4();
//        System.out.println("CyclicBarrier、Runnable同时并行,支持返回 开始============================================================");
//        demo.alibabaThreadPool5();
    }


    //资源类  线程操作资源类  有返回值
    class MyCallable implements Callable<Object> {

        @Override
        public Object call() throws Exception {

            System.out.println(Thread.currentThread().getName() + "开始时间:" +
                    DateFormat.getTimeInstance().format(new Date()));
            int rand = new Random().nextInt(5) * 1000;
            System.out.println(Thread.currentThread().getName() + "睡眠" + rand);
            Thread.sleep(rand);
            Map<String, String> map = new HashMap<>(16);
            map.put("back", Thread.currentThread().getName() + "成功了");
            System.out.println(Thread.currentThread().getName() + "结束时间:" +
                    DateFormat.getTimeInstance().format(new Date()));
            return map;
        }
    }

    //资源类  线程操作资源类  无返回值
    class MyRunnable2 implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public MyRunnable2(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                // 等待所有任务准备就绪
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "开始时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                int rand = new Random().nextInt(5) * 1000;
                System.out.println(Thread.currentThread().getName() + "睡眠" + rand);
                Thread.sleep(rand);
                // 测试内容
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "结束时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //资源类  线程操作资源类  有返回值
    class MyCallable2 implements Callable<Object> {

        private CyclicBarrier cyclicBarrier;

        public MyCallable2(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public Object call() throws Exception {
            this.cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "开始时间:" +
                    DateFormat.getTimeInstance().format(new Date()));
            int rand = new Random().nextInt(5) * 1000;
            System.out.println(Thread.currentThread().getName() + "睡眠" + rand);
            Thread.sleep(rand);
            Map<String, String> map = new HashMap<>(16);
            map.put("back", Thread.currentThread().getName() + "成功了");
            System.out.println(Thread.currentThread().getName() + "结束时间:" +
                    DateFormat.getTimeInstance().format(new Date()));
            return map;
        }
    }


    /**
     * Future、Callable有返回值，get()阻塞串行
     * 有返回 串行
     */
    public void alibabaThreadPool2() throws Exception {

        int corePoolSize = 5;

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my-pool-%d").build();
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(200);

        ExecutorService threadPool = new ThreadPoolExecutor(
                corePoolSize,
                6,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        while (corePoolSize > 0) {
            try {
                Future future = threadPool.submit(new MyCallable());
                //会阻塞（串行）
                Map<String, String> map = (Map<String, String>) future.get();

                System.out.println("返回：" + map.get("back"));
                System.out.println("----------------华丽的分割线-------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            corePoolSize--;
        }
        threadPool.shutdown();
    }

    /**
     * Future Callable支持返回,并行
     * <p>
     * 有返回,并行
     */
    public void alibabaThreadPool3() throws ExecutionException, InterruptedException {
        int corePoolSize = 5;

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my-pool-%d").build();
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(200);

        ExecutorService threadPool = new ThreadPoolExecutor(
                corePoolSize,
                6,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Future> list = new ArrayList<>();

        while (corePoolSize > 0) {

            Future future = threadPool.submit(new MyCallable());
            list.add(future);
            corePoolSize--;
        }

        for (Future future : list) {
            Map<String, String> map = (Map<String, String>) future.get();
            System.out.println("返回: " + map.get("back"));
        }
        threadPool.shutdown();
    }


    /***
     * CyclicBarrier同时并行,一般用来测试并发
     * @throws Exception
     */
    public void alibabaThreadPool4() throws Exception {
        //线程池核心池的大小
        int corePoolSize = 100;
        ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().setNameFormat("my-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
        //注意cyclicBarrier对象不能在循环里面多次new，线程会挂，同时平时开发可以共享的尽量不要在循环里去new，影响性能
        CyclicBarrier cyclicBarrier = new CyclicBarrier(corePoolSize);
        for (int i = 0; i < corePoolSize; i++) {
            threadPool.execute(new MyRunnable2(cyclicBarrier));
        }
        threadPool.shutdown();
    }


    /***
     * 有返回,CyclicBarrier同时并行,一般用来测试并发
     * @throws Exception
     */
    public void alibabaThreadPool5() throws Exception {
        //线程池核心池的大小
        int corePoolSize = 5;
        ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().setNameFormat("my-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
        List<Future> list = new ArrayList<>();
        //注意cyclicBarrier对象不能在循环里面多次new，线程会挂，同时平时开发可以共享的尽量不要在循环里去new，影响性能
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        while (corePoolSize > 0) {
            System.out.println(corePoolSize + "开始:" +
                    DateFormat.getTimeInstance().format(new Date()));
            Future future = threadPool.submit(new MyCallable2(cyclicBarrier));
            list.add(future);
            System.out.println(corePoolSize + "结束:" +
                    DateFormat.getTimeInstance().format(new Date()));
            corePoolSize--;
        }
        for (Future future : list) {
            Map<String, String> map = (Map<String, String>) future.get();
            System.out.println("返回：" + map.get("back"));
        }
        threadPool.shutdown();

    }

}
