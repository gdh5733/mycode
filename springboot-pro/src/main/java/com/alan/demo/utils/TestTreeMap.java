package com.alan.demo.utils;

import java.util.*;

/**
 * @Description treemap可以实现key的默认排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/18
 */

public class TestTreeMap {

    public static void main(String[] args) {
//        testTreemapMethod();
        testOrderByComprable();
    }

    /**
     * 测试Treemap实现key的排序
     */
    public static void testTreemapMethod(){

        Map<String,String> map = new TreeMap<>();
        map.put("5","这个值是五");
        map.put("2","这个值是二");
        map.put("1","这个值是一");

        map.forEach((k,v)->{
            System.out.println("输出的值为:"+k+" "+v);
        });

    }

    /**
     *按照对象的
     */
    public  static void testOrderByComprable(){
        Emp emp = new Emp("6","小明");
        Emp emp1 = new Emp("2","小王");
        Emp emp2 = new Emp("5","小高");

        List<Emp> list = new ArrayList<>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2);

        list.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                Integer i1 = Integer.parseInt(o1.getId());
                Integer i2 = Integer.parseInt(o2.getId());
                return i1.compareTo(i2);
            }
        });

        list.forEach(val->{

            System.out.println(val);

        });

    }

}

class Emp {


    private String id;
    private String name;

    public Emp(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
