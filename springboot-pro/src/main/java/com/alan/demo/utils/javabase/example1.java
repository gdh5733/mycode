package com.alan.demo.utils.javabase;

/**
 * @Description 为什么Java中只有值传递
 * <p>
 * Java 程序设计语言总是采用按值调用。也就是说，方法得到的是所有参数值的一个拷贝，
 * 也就是说，方法不能修改传递给它的任何参数变量的内容。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class example1 {


    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    private static void swap(int a, int b) {

        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
