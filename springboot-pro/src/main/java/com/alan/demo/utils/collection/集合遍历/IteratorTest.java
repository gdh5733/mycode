package com.alan.demo.utils.collection.集合遍历;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description Iterator接口遍历集合
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/13
 */

public class IteratorTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("1", "val1");
        map.put("2", "val2");
        map.put("3", "val3");

        map.forEach((k, v) -> {
            System.out.println(k + v);
        });
    }
}
