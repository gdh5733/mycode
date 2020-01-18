package com.alan.demo.juc;

/**
 * @Description 测试单例
 * 双重锁机制能够保证效率的提升
 * volatile 能够避免指令重排  -->保证初始化完成之后赋值给这个变量
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class TestDcl {

    private static volatile TestDcl instance;

    private TestDcl() {
    }

    public static TestDcl getInstance() {

        synchronized (TestDcl.class) {
            //双重锁机制
            if (instance == null) {
                instance = new TestDcl();
                return instance;
            }
        }

        return instance;
    }


}
