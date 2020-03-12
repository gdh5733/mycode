package com.alan.demo.utils.string;
/**
 * @Description String(不可变性)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/29
 */

public class StringTest {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
        test3();
        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * String： 字符串,使用一对""引起来表示。
     * 1.String 声明为final的,不可被继承
     * 2.String 实现了Seriallizable接口: 表示字符串是支持序列化的
     * 实现了Comparable接口： 表示String可以比较大小
     * 3.String内部定义了final char[] value 用于存储字符串数据
     * 4.String 代表不可变的字符序列  简称: 不可变性
     *
     * 体现:1.当字符串重新赋值时，需要重写指定内存区域赋值,不能使用原有的value赋值
     * 2.当对现有的字符串进行连接操作时,也需要重新指定内存区域赋值,不能使用原有的value赋值
     *
     * 5.通过字面量的方式(区别于new)给一个字符串赋值,此时的字符串声明在字符串常量池中。
     * 6.字符串常量池中是不会存储相同内容的字符串的。
     */
    public static void test1() throws InterruptedException {
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1);
        System.out.println(s2);

    }

    /**
     * 相当于在栈中创建了一个引用,然后在堆空间中创建对象,然后指向常量池中的对象
     * 比如说是 Tom
     */
    public static void test2() {
        Person p1 = new Person("Tom", 12);

        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true

        p1.name = "Jerry";
        System.out.println(p2.name);//Tom
    }

    /**
     * String经典面试题
     * <p>
     * 结论:
     * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
     * 2. 只要其中有一个是变量,结果就在堆中
     */
    public static void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";


        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false

        String s8 = s5.intern();//返回值得到的s8使用常量池中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);//true
    }

}
