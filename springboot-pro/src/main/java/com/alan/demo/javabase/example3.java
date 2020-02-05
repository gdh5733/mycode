package com.alan.demo.javabase;

import com.alan.demo.javabase.entity.Student;

/**
 * @Description 很多程序设计语言（特别是，C++和 Pascal)提供了两种参数传递的方式：值调用和引用调用。
 * 有些程序员（甚至本书的作者）认为 Java 程序设计语言对对象采用的是引用调用，
 * 实际上，这种理解是不对的。由于这种误解具有一定的普遍性，所以下面给出一个反例来详细地阐述一下这个问题。
 * <p>
 * <p>
 * 总结:
 * Java 程序设计语言对对象采用的不是引用调用，实际上，对象引用是按 值传递的。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class example3 {

    public static void main(String[] args) {

        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        example3.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

    }

    /**
     * 交换
     * 实际上是按值传递
     * 中间发生了 引用拷贝
     *
     * @param x 引用x
     * @param y 引用y
     */
    private static void swap(Student x, Student y) {

        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x: " + x.getName());
        System.out.println("y: " + y.getName());
    }

}
