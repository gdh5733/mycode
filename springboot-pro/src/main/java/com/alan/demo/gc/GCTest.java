package com.alan.demo.gc;

/**
 * @Description 测试gc新生代 与老年代
 * <p>
 * 字节也叫Byte，是计算机数据的基本存储单位，在电脑里一个中文字占两个字节。
 * 8bit(位)=1Byte(字节)
 * <p>
 * 1024Byte(字节)=1KB
 * 1024KB=1MB
 * <p>
 * 1024MB=1GB
 * 1024GB=1TB
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/10
 */

public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900 * 1024];

    }
}
