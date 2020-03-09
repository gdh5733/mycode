package com.alan.demo.service.transation;

import java.util.List;

public interface CashierService {

    /**
     * 结账
     *
     * @param uid  用户
     * @param bids 买了几本书
     * @parm bid 书的id
     */
    void checkout(Integer bid, Integer uid, List<Integer> bids);

}
