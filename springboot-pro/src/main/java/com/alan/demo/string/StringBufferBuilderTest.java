package com.alan.demo.string;

/**
 * @Description 关于StringBuffer 和StringBuilder的使用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/29
 */

public class StringBufferBuilderTest {

    /*
     String,StringBuffer,StringBuilder三者的异同?
     String: 不可变的字符序列;底层使用char[] 数组存储
     StringBuffer: 可变的字符序列 线程安全的,效率偏低
     StringBuilder: 可变的字符序列: jdk5.0新增线程不安全的,效率高;

    源码分析：
    String str = new String(); //char[] value = new char[0];
    String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16]; 创建一个长度为16的数组
    sb1.append('a');//value[0] = 'a';
    sb1.append('b');//value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]

    StringBuffer StringBuilder中的常用方法

    增: append(xxx)
    删: delete(int start,int end)
    改: setCharAt(int n,char ch)
    查: charAt(int n)
    插: insert(int offset,xxx)
    长度: length()
     */
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        stringBuilder.append("456");
        System.out.println(stringBuilder.toString());
    }

}
