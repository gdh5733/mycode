package com.alan.demo.service.transation;

import com.alan.demo.entity.Book;
import com.alan.demo.entity.Money;
import com.alan.demo.entity.Stock;
import com.alan.demo.mapper.BookMapper;
import com.alan.demo.mapper.MoneyMapper;
import com.alan.demo.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/9
 */

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    StockMapper stockMapper;

    @Autowired
    MoneyMapper moneyMapper;

    /**
     * 通过书的编号查询书的价格
     *
     * @param id
     */
    @Override
    public void selectPrice(Integer id) {
        bookMapper.selectByPrimaryKey(id);
    }


    /**
     * @param bid   书的id
     * @param uid   用户的id
     * @param count 买的数量
     */
    @Override
    public void buyBook(Integer bid, String uid, Integer count) {

        //查出信息
        Book bk = bookMapper.selectByPrimaryKey(Integer.valueOf(bid));
        Stock st = stockMapper.selectByPrimaryKey(Integer.valueOf(bid));
        Money my = moneyMapper.selectByPrimaryKey(Integer.valueOf(uid));

        //更新库存

        if (count > st.getSt()) {
            throw new RuntimeException("库存不足");
        } else {

            Stock stock = new Stock();
            stock.setSid(Integer.valueOf(bid));
            stock.setSt(st.getSt() - count);
            stockMapper.updateByPrimaryKey(stock);
        }


        //更新账户余额
        if (my.getBalance() < count * bk.getPrice()) {
            throw new RuntimeException("余额不足");
        } else {
            Money money = new Money();
            money.setUid(Integer.valueOf(uid));
            money.setBalance(my.getBalance() - bk.getPrice() * count);
            moneyMapper.updateByPrimaryKey(money);
        }
    }

}
