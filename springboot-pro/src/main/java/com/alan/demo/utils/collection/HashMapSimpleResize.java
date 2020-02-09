package com.alan.demo.utils.collection;

import java.util.HashMap;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/27
 */

public class HashMapSimpleResize {

    private static HashMap map = new HashMap();

    public static void main(String[] args) {
        //扩容的阀值是table.length*0.75
        //第一次扩容发生在第13个元素置入时
        for (int i = 0; i < 13; i++) {
//            map.put();
        }
    }

    void resize(int newCapacity) {

    }



}

class UserKey {

    //目的是让所有的Entry都在同一个哈希桶内
    public int hashCode() {
        return 1;
    }

    //如果为true,则会对同一个Key上的值进行覆盖,不会形成链表
    public boolean equals() {
        return false;
    }

}
