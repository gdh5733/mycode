package com.alan.demo.utils.设计模式.策略模式解决ifelse;


import org.springframework.stereotype.Service;

@Service
public interface IOrderService {


    /**
     * 根据订单的不同类型做出不同的处理
     *
     * @param dto
     * @return
     */
    String handle(OrderDTO dto);

}
