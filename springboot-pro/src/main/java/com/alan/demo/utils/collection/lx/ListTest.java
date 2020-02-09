package com.alan.demo.utils.collection.lx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description 在List内去重复数字值, 要求尽量简单
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/24
 */

public class ListTest {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    /**
     * List中去除重复的元素 尽量简单
     *
     * @param list
     * @return
     */
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    /**
     * 向Set中添加元素
     * 先按照hashCode()计算  在equals()比较 目的是提高效率
     */
    public static void test3() {

        HashSet set = new HashSet();
        Person p1 = new Person();
        Person p2 = new Person();
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
    }
}
