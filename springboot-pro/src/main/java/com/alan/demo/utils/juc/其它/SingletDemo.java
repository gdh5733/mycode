package com.alan.demo.utils.juc.其它;

/**
 * @Description 多线程下 单例模式
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/19
 */

public class SingletDemo {

    //加volatile的作用是为了避免指令重排
    //因为在创建对象的时候 实际jvm 是分了三个动作  1.给对象分配空间  2.给对象初始化 3.引用指向空间地址(真正创建对象完毕)
    //这三个步骤容易出现指令重排 所以加入volatile 关键字
    private static volatile SingletDemo instance = null;

    //正常并发情况下 这个构造方法只能被调用一次
    private SingletDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }

    //DCL(Double Check Lock双端检验锁)
    public static SingletDemo getInstance() {

        if (instance == null) {
            synchronized (SingletDemo.class) {
                if (instance == null) {
                    instance = new SingletDemo();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

        //单线程(main线程的操作动作)
//        System.out.println(SingletDemo.getInstance());
//        System.out.println(SingletDemo.getInstance());
//        System.out.println(SingletDemo.getInstance());
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        //
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
