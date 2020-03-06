package com.alan.demo.utils.设计模式.模板;

/**
 * @Description 模板方法   也叫回调方法  钩子函数
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/6
 */

public class Main {

    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F {

    void m() {
        op1();
        op2();
    }

    abstract void op1();

    abstract void op2();

}

class C1 extends F {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
