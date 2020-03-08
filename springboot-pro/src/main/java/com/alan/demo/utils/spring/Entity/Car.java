package com.alan.demo.utils.spring.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 该实体类用于测试自动装配 (即自动注入 前面的基本数据类型在在配置文件中是以ref指定的 )
 * 即 当一个对象依赖 另一个对象的时候 不需要在显示的在spring配置文件中  以 ref 形式引用   可以直接使用autowaired 来设置
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

@Getter
@Setter
@ToString
public class Car {

    //小汽车的品牌
    private String band;

    //车牌号
    private String cid;


}
