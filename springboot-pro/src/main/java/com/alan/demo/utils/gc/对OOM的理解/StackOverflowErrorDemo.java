package com.alan.demo.utils.gc.对OOM的理解;

/**
 * @Description StackOverflowError
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class StackOverflowErrorDemo {


    public static void main(String[] args) {
        stackOverflowError();
    }


    private static void stackOverflowError() {
        //Exception in thread "main" java.lang.stackOverflowError
        stackOverflowError();
    }

}
