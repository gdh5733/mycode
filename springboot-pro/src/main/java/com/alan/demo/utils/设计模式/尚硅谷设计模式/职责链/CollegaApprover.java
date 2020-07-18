package com.alan.demo.utils.设计模式.尚硅谷设计模式.职责链;
/**
 * 大学处理
 */
public class CollegaApprover extends Approver
{

    public CollegaApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()<5000 && purchaseRequest.getPrice()<10000){
            System.out.println("请求编号id= "+purchaseRequest.getId()+"被"+this.name+"请求了");
        }else{
            approver.processRequest(purchaseRequest);
        }
    }
}




