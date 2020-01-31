package com.alan.demo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description ArrayList 源码分析
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */

public class ListTest {


    public static void main(String[] args) {

        ListTest test = new ListTest();
        test.testList();
    }


    /**
     * 测试list remove
     */
    public void testList() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(new Integer(2));

        System.out.println(list);

    }


}