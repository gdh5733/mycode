package com.alan.demo.collection;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/26
 */

public class TreeMapTest {
    //向TreeMap中添加key-value, 要求key必须是由同一个类创建的对象
    //因为要按照key进行排序: 自然排序,定制排序

    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 自然排序
     */
    public static void test1() {

        TreeMap map = new TreeMap();

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 20);
        User u4 = new User("Rose", 18);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 76);
        map.put(u4, 100);

        map.forEach((k, v) -> {
            System.out.println("键的值为: " + k + "  值为: " + v);
        });

    }

    /**
     * 自定义排序
     */
    public static void test2() {

        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User) o1;
                User u2 = (User) o2;

                return Integer.compare(u1.getAge(), u2.getAge());
            }
        });

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 20);
        User u4 = new User("Rose", 18);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 76);
        map.put(u4, 100);

        map.forEach((k, v) -> {
            System.out.println("键的值为: " + k + "  值为: " + v);
        });
    }


}
