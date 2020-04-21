package com.alan.demo.utils.数据结构与算法.队列;

import java.util.Scanner;

/**
 * @Description 用数组模拟实现队列
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/31
 */

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        //用户接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列去除数据");
            System.out.println("h(head): 查看队列头数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            if (key == 's') {
                queue.showQueue();
            } else if (key == 'a') {
                System.out.println("输入一个数:");
                int value = scanner.nextInt();
                queue.addQueue(value);
            }
        }
    }

    //使用数组模拟队列编写一个ArrayQueue
    static class ArrayQueue {

        //表示数组的最大容量
        private int maxSize;

        //队列头
        private int front;

        //队列尾
        private int rear;

        //创建队列的构造器
        private int[] arr;

        //创建队列的构造器
        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            //指向队列头部,分析出front是指向队列头的前一个位置
            front = -1;

            //指向队列的尾部的数据(即就是队列最后的一个数据)
            rear = -1;
        }

        //判断队列是否满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        //添加数据到队列
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满,不能加入数据");
                return;
            }
            //让rear 后移
            rear++;
            arr[rear] = n;
        }

        //获取队列中的数据,出队列
        public int getQueue() {

            //判断队列是否为空
            if (isEmpty()) {
                //通过抛出异常
                throw new RuntimeException("队列为空,不能取数据");
            }
            front++;
            return arr[front];
        }

        //显示队列的所有数据
        public void showQueue() {
            //遍历
            if (isEmpty()) {
                System.out.println("队列为空的,没有数据~~");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        //显示队列的头部数据,注意不是把数据取出来
        public int headQueue() {
            //判断
            if (isEmpty()) {
                System.out.println("队列空的,没有数据~~");
                throw new RuntimeException("无数据~~");
            }
            return arr[front + 1];
        }
    }
}
