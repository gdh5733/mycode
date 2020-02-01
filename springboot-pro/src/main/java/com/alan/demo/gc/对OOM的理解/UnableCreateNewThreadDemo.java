package com.alan.demo.gc.对OOM的理解;

/**
 * @Description java.lang.OutOfMemoryError: unable to create new native thread
 * 高并发请求服务器的时候,经常出现如下异常: java.lang.OutOfMemoryError: unable to create new native thread
 * 准确的讲该native thread 异常与对应的平台有关
 * <p>
 * 导致原因:
 * 1  你的应用创建了太多线程了,一个应用进程创建多少线程,超过系统承载极限
 * 2  你的服务器不允许你的应用程序创建这么多线程,linux系统默认允许单个进程可以创建的线程数是1024个,
 * 你的应用创建超过这个数量,就会报java.lang.OutOfMemoryError: unable to create new native thread
 * <p>
 * 解决方法:
 * 1.想办法降低你的应用程序创建线程的数量,分析应用是否真的需要创建这么多线程,如果不是,改代码将线程数降到最低
 * 2.对于有的应用,确实需要创建很多线程,远超过linux系统的默认1024个线程的限制,可以通过修改linux服务器配置,扩大linux默认限制
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class UnableCreateNewThreadDemo {


    public static void main(String[] args) {

        for (int i = 1; ; i++) {
            System.out.println("******i = " + i);
            new Thread(() -> {

                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "" + i).start();
        }

    }
}
