package com.alan.demo.utils.enums;


/**
 * 相当于一个小型的mysql来使用   枚举 ContryEnum 相当于是库        ONE TWO THREE 就相当于是表  里边的值就相当于是列
 */


public enum ContryEnum {

    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");


    private Integer retCode;


    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    ContryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static ContryEnum foreach_CountryEnum(int index) {
        ContryEnum[] myArray = ContryEnum.values();

        for (ContryEnum element : myArray) {
            if (index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
