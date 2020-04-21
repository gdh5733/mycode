package com.alan.demo.utils.数据结构与算法.字符串算法;

import java.util.*;

/**
 * @Description 找出字符串重复的字符
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/2
 */

public class Test {


    public static void main(String[] args) {
        meth1();
        meth2();

    }

    /**
     * 方法一
     */
    public static void meth1() {
        String str = "abccb";

        List<Object> list = new ArrayList<>();
        char[] arr = str.toCharArray();

        Map<Object, Object> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list.add(arr[i]);
            } else {
                map.put(arr[i], arr[i]);
            }
        }
        list.forEach(val -> {
            System.out.println("重复的字符串值为:" + val);
            System.out.println();
        });

    }

    /**
     * 方法二
     */
    public static void meth2() {
        List<Object> list = new ArrayList<>();
        String str = "abccb";
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    list.add(arr[i]);
                    continue;
                }
            }
        }

        list.forEach(val -> {
            System.out.println("重复的值为:" + val);
        });

        return;
    }
}




