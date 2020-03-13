package com.alan.demo.utils.enums;

/**
 * 相当于一个小型的mysql来使用   枚举 ContryEnum 相当于是库        ONE TWO THREE 就相当于是表  里边的值就相当于是列
 *
 * 类的对象只有有限个,确定的。举例如下:
 * 星期: Monday(星期一),....Sunday(星期天)
 * 性别: Man(男).Woman(女)
 * 季节:Spring(春节)....Winter(冬天)
 * 支付方式: Cash(现金),WeChatPay(微信),Alipay(支付宝),BankCard(银行卡),CreditCard(信用卡)
 * 就职状态:Busy,Free,Vocation,Dimission
 * 订单状态:Nonpayment(未付款),Paid(已付款),Deliver(已发货),Return(退货)，Checked(已确认),Fulfilled(以配货)
 * 线程状态: 创建,就绪,运行,阻塞,死忙
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
