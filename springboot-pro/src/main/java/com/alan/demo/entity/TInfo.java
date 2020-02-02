package com.alan.demo.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
//import lombok.Data;

@ApiModel(value = "用户信息")
@Data
public class TInfo {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户手机号")
    private String telephone;

    @ApiModelProperty(value = "用户地址")
    private String userAddress;


}