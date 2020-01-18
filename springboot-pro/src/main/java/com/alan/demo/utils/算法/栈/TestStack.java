package com.alan.demo.utils.算法.栈;

import java.util.Stack;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */

//演示栈Stack的基本使用
public class TestStack {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        while (stack.size() > 0) {
            //pop就是将栈定的数据取出
            System.out.println(stack.pop());
        }
    }
}
