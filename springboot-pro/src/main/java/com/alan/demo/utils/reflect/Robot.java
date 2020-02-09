package com.alan.demo.utils.reflect;

/**
 * @Description 测试反射机制
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */

public class Robot {

    private String name;

    static {
        System.out.println("验证forName是代码初始化完成了");
    }

    public void sayHi(String helloSentence) {

        System.out.println(helloSentence + " " + name);
    }

    private String throwHello(String tag) {
        return "Hello " + tag;
    }


}
