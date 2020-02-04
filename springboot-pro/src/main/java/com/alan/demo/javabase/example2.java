package com.alan.demo.javabase;

/**
 * @Description 我们已经知道了一个方法不能修改一个基本数据类型的参数，
 * 而对象引用作为参数就不一样
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class example2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);

    }

    private static void change(int[] array) {
        //将数组的第一的元素变为0
        array[0] = 0;

    }

}
