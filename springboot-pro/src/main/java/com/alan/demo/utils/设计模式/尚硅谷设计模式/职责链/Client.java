package com.alan.demo.utils.设计模式.尚硅谷设计模式.职责链;

public class Client {

    public static void main(String[] args) {

        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1,1000,1);

        //创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");

        CollegaApprover collegaApprover = new CollegaApprover("李院长");

        //需要将各个审批级别的下一个设置好（处理人构成环型）
        departmentApprover.setApprover(collegaApprover);

        departmentApprover.processRequest(purchaseRequest);
    }
}
