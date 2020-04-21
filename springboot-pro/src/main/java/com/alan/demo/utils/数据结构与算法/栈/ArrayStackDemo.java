package com.alan.demo.utils.数据结构与算法.栈;

import java.util.Scanner;

/**
 * @Description 用数组来模拟栈
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */

public class ArrayStackDemo {


    public static void main(String[] args) {
        //测试一下ArrrayStaclz 是否正确
        ArrayStackz stackz = new ArrayStackz(4);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;

        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈去除数据(出栈)");
            key = scanner.next();

            switch (key) {
                case "show":
                    stackz.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stackz.push(value);
                    break;
                case "pop":
                    try {
                        int res = stackz.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

//用数组模拟栈
class ArrayStackz {
    //栈的大小
    private int maxSize;

    //数组,数组模拟栈,数据就放在该数组
    private int[] stack;

    //top表示栈顶,初始化为-1
    private int top = -1;

    //构造器
    public ArrayStackz(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop 将栈顶的数据返回
    public int pop() {
        //先判断栈是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空,没有数据");
        }

        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况【遍历栈】,遍历时,需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据~~");
            return;
        }

        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }


}
