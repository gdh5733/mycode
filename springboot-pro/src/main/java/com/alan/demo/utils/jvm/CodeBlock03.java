package com.alan.demo.utils.jvm;

/**
 * @Description 加载代码练习
 *
 * 静态代码块->代码块->构造方法
 *
 *
 * @Author gaodehan且静态代码块只加载一遍
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/24
 */


class CodeZY {

    public CodeZY() {
        System.out.println("code的构造方法1111");
    }

    {
        System.out.println("Code的构造块2222");
    }

    static {
        System.out.println("code的静态代码块3333");
    }
}

public class CodeBlock03 {

    {
        System.out.println("CodeBlock03的构造块444");
    }

    static {
        System.out.println("codeblock03静态代码块555");
    }

    public CodeBlock03() {
        System.out.println("codeblock03的构造方法666");
    }

    public static void main(String[] args) {

        System.out.println("---------------开始加载----------------");
        CodeZY obj1 = new CodeZY();
        System.out.println("--------------------------------------");

        new CodeZY();
        System.out.println("--------------------------------------");
        new CodeBlock03();
    }
}


