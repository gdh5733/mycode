package com.alan.demo.juc;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/6
 */

public class TestSynchroized {

    private Object object = new Object();

    public static void main(String[] args) {
        TestSynchroized val = new TestSynchroized();
        val.test();
    }


    public void test() {

        synchronized (object) {
            System.out.println("执行完成");
        }

    }
}
