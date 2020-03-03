package com.alan.demo.utils.泛型.泛型类;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description 泛型类
 * <p>
 * 泛型的概念
 * Java泛型是JDK5中引入的一个新特性,非泛型提供了编译时类型安全监测机制,该机制允许我们在编译时
 * 检测到非法的类型数据结构
 * <p>
 * 泛型的本质就是参数化类型,也就是所操作的数据类型被指定为一个参数
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/3
 */

public class MainClass<T> {

    public static void main(String[] args) {

//        Generic<String> stringGeneric = new Generic<>("abc");
//        String key1 = stringGeneric.getKey();
//        System.out.println("key1: " + key1);
//
//        List<String> list = new ArrayList<>();

        ProductGetter<String> productGetter = new ProductGetter<>();

        String[] str = {"苹果手机", "华为手机", "小米手机"};

        for (int i = 0; i < str.length; i++) {
            productGetter.addProduct(str[i]);
        }

        String val = productGetter.getProduct();
        System.out.println("抽中的奖品为: " + val);
    }
}


//泛型类
class Generic<T> {

    //T 是由外部使用类的时候指定的
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

}

//泛型类 抽奖
class ProductGetter<T> {

    Random random = new Random();

    private T product;

    ArrayList<T> list = new ArrayList<>();

    //添加奖品
    public void addProduct(T t) {
        list.add(t);
    }

    //获取奖品
    public T getProduct() {
        T t = list.get(random.nextInt(list.size()));
        return t;
    }

}
