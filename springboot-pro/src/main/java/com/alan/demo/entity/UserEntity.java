package com.alan.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */


@Data
public class UserEntity implements Serializable {

    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;

}
