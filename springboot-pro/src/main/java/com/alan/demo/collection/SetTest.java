package com.alan.demo.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description 1.Set 接口的框架
 * <p>
 * ----Collection接口 单列集合,用来存储一个一个的对象
 * ----Set接口 存储无序的,不可重复的数据 --> 高中讲的集合
 * ---HashSet 作为Set接口的主要实现类;线程不安全的;可以存储null值
 * ---LinkedHashSet：作为HashSet的子类:遍历其内部数据时,可以按照添加的顺序
 * ---TreeSet：可以按照添加对象的指定属性,进行排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/21
 */

public class SetTest {

    /**
     * Set:
     * 1.存储无序的，
     * 2.不可重复的数据
     */

    public void test1() {
        Set set = new HashSet<>();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom", 12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * LinkHashSet底层是用的数组+链表
     * 但和HashSet不同的是多了一层链表能够准确找到每个添加的元素
     */
    public void testLinkHashSet() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(789);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String val = (String) iterator.next();
            System.out.println(val);
        }

    }
}



