package com.alan.demo.gc;

/**
 * @Description GC相关参数  boolean类型   KV类型
 * 调试相关命令
 * 1.jps -l
 * 2. jinfo -flag MetaspaceSize 线程ID
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/31
 */

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("******HelloGC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
