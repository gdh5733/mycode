package com.alan.demo.gc;

/**
 * @Description GC相关参数  boolean类型   KV类型
 * 调试相关命令
 * 1.jps -l
 * 2. jinfo -flag MetaspaceSize 线程ID
 * <p>
 * 第一种,查看参数盘点点家底
 * jps
 * jinfo -flag 具体参数  java进程编号
 * jinfo -flags         java进程编号
 * <p>
 * 第二种,查看参数盘点家底
 * java -XX:+PrintFlagsInitial   查看JVM初始化的一些参数
 * java -XX:+PrintFlagsFinal = :=    主要查看修改更新
 * java -XX:+PrintFlagsFinal -XX:MetaspaceSize=512 T 其中T为类的名字   修改初始化参数的值并同时查看
 *
 * 第三种,查看参数盘点家底
 * java -XX:+PrintCommandLineFlags -version
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
