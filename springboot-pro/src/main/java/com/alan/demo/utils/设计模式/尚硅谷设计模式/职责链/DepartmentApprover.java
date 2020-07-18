package com.alan.demo.utils.设计模式.尚硅谷设计模式.职责链;

/**
 * 部门处理
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
            if(purchaseRequest.getPrice()<=5000){
                System.out.println("请求标号id= "+purchaseRequest.getPrice()+"被"+this.name+"处理");
            }else {
                approver.processRequest(purchaseRequest);
            }
    }
}
