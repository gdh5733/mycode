package com.alan.demo.gc.强软弱虚引用;

/**
 * @Description 强引用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class StrongReferenceDemo {

    public static void main(String[] args) {

        Object obj1 = new Object();//这样定义的默认就是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj2);
    }

}
