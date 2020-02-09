//package com.alan.demo.utils.aop;
//import org.springframework.stereotype.Component;
//
///**
// * @Description
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2019/12/25
// */
//
//@Component
//public class AliPay implements Payment {
//
//
//    private Payment payment;
//
//     public  AliPay(Payment payment){
//         this.payment = payment;
//     }
//
//    public void  beforePay(){
//        System.out.println("从银行取款");
//    };
//
//
//    @Override
//    public void pay() {
//      beforePay();
//      payment.pay();
//      afterPay();
//    }
//
//
//    public  void afterPay(){
//        System.out.println("支付给慕课网");
//
//    }
//}
