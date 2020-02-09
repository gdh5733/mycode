package com.alan.demo.utils.thread;

/**
 * @Description 测试线程 通过实现Runnable接口的方法
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/30
 */

public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start : " + this.name + ",i=" + i);
        }
    }
}
