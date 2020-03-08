package com.alan.demo.utils.spring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 用于自动装配的验证
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

@Setter
@Getter
@ToString
public class Dept {

    //部门的ID
    private String eid;

    //部门的名字
    private String name;

    /**
     * 员工拥有的小汽车
     */
    private Car car;

}
