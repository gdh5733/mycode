package com.alan.demo.utils.设计模式;

/**
 * @Description 适配器本身(用到了组合)
 * (相当于usb和ps/2的转接器)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/19
 */

public class adapter implements Target {

    adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    //提供构造器  将adaptee(相当于键盘)传入进来
    public adapter(adaptee adaptee) {
        this.adaptee = adaptee;
    }


}
