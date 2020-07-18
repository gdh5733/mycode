package com.alan.demo.utils.设计模式.尚硅谷设计模式.职责链;

public class PurchaseRequest {

    private int type = 0;//请求类型
    private float price = 0.0f;//请求的金额
    private int id = 0;

    //构造器
    public PurchaseRequest(int type,float price,int id){
        super();
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
