package com.alan.demo.utils.数据结构与算法.字符串算法;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/12
 */

public class StringTest {


    /***
     * 查找出重复的字符串
     * @param str
     */
    public static void test1(String str) {
        int count = 0;
        char[] res = new char[str.length()];
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    res[count] = array[i];
                    count++;
                    break;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println("重复的字符为:" + res[i]);
        }
    }


    public static void main(String[] args) {
        test1("1233556");
    }
}
