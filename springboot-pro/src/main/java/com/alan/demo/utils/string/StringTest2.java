package com.alan.demo.utils.string;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/29
 */

public class StringTest2 {

    /**
     * string经典面试题
     */
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest2 ex = new StringTest2();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
