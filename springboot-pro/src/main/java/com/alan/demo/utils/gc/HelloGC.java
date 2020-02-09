package com.alan.demo.utils.gc;

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
 * <p>
 * 第三种,查看参数盘点家底
 * java -XX:+PrintCommandLineFlags -version   也是一种查看初始参数
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/31
 */

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("******HelloGC");
//        Thread.sleep(Integer.MAX_VALUE);
//        byte[] byteArray = new byte[50 * 1024 * 1024];

    }


    /**
     * 程序测试堆的最大内存 和最小内存
     */

    public static void memoryTest() {
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();//返回 Java虚拟机试图使用的最大内存量
        System.out.println("TOTAL_MEMORY(-Xms)= " + totalMemory + " (字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + " (字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");
    }

    /**
     * 典型设置案列
     * -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:
     * +PrintGCDetails -XX:+UseSerialGC
     * 常用参数
     * <p>
     * 1.-Xms 初始大小内存,默认为物理内存1/64 等价于 -XX:InitialHeapSize
     * 2.-Xmx 最大分配内存,默认为物理内存1/4  等价于 -XX:MaxHeapSize
     * 3.-Xss 设置单个线程栈的大小,一般默认为512k~1024k 等价于-XX:ThreadStackSize
     * 4.-Mmn 设置年轻代大小
     * 5.-XX:MetaspaceSize 设置元空间大小   元空间的本质和永久代类似,都是对JVM规范中方法区的 不过元空间与永久代之间最大的区别在于: 元空间并不在虚拟机中,而是使用本地内存 因此默认情况下,元空间的大小仅受本地内存限制
     * 6.-XX:+PrintGCDetails
     * 7.-XX:SurvivorRatio  默认-XX:SurvivorRatio=8,Eden:S0:S1 = 8:1:1 假如 -XX:SurvivorRatio=4,Eden:S0:S1 = 4:1:1,SurvivorRatio值就是设置eden区的比例占多少,S0/S1相同
     * 8.-XX:NewRatio 配置年轻代与老年代在堆结构的占比 默认-XX:NewRatio=2新生代占1,老年代占2,年轻代占整个堆的1/3 假如-XX:NewRatio=4新生代占1,老年代4,年轻代占整个堆的1/5 NewRatio值就是设置老年代的占比,剩下的1给新生代
     * 9.-XX:MaxTenuringThreshold 设置垃圾最大年龄 默认是15 JDK 1.8   只能调节到 0-15之间
     */
    public static void memoryTest1() {

    }

}
