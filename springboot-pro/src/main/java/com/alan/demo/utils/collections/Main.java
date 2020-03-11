package com.alan.demo.utils.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(10);
        list.add(9);
        list.add(1);

        list.forEach(val -> {
            System.out.println(val);
        });

    }

}
