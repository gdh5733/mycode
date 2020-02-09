package com.alan.demo.utils.gc.对OOM的理解;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class JavaHeapSpaceDemo {


    public static void main(String[] args) {

        /**
         * -Xmx50m -Xms50 -XX:PrintGCDetails
         */

        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        byte[] bytes = new byte[80 * 1024 * 1024];


    }

}
