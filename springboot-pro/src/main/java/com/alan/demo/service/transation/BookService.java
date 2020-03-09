package com.alan.demo.service.transation;

public interface BookService {

    /**
     * 根据图书的id查询图书的价格
     *
     * @param id
     */
    void selectPrice(Integer id);


    /**
     * 买书
     *
     * @param bid   书的id
     * @param uid   用户的id
     * @param count 买的数量
     */
    void buyBook(Integer bid, String uid, Integer count);
}
