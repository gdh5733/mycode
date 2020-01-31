package com.alan.demo.string;

/**
 * @Description 字符串常用方法
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/29
 */

public class StringMethodTest {


    public static void main(String[] args) {

    }

    /**
     * 字符串常用方法1
     */
    public void test1() {
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.substring(2));
    }

    /**
     * 字符串常用方法2
     * <p>
     * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     * boolean startsWith(String prefix)： 测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix,int toffset): 测试此字符串从指定索引开始的子字符串
     */
    public void test2() {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);
    }






}
