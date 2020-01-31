package com.alan.demo.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description 关于Collection接口中声明难过的方法的测试
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */

public class CollectionTest {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.contains(123);

        coll.add(new String("Tom"));

        coll.contains(new String("Tom"));
        User user = new User("alan", 25);
        coll.add(user);
        System.out.println(coll.contains(new User("alan", 25)));

    }
}
