package com.alan.demo.utils.设计模式;

/**
 * @Description 客户端类
 * (相当于例子中的笔记本,只有USB接口)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/19
 */

public class Client {

    public void test(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        //相当于客户端(笔记本)
        Client c = new Client();

        //相当于键盘
        adaptee a = new adaptee();

        Target t = new adapter(a);
        c.test(t);
    }


}
