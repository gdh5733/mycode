package com.alan.demo.service.transation;

import com.alan.demo.entity.Stock;
import com.alan.demo.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/9
 */

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;

    /**
     * 根据书的id进行更新
     *
     * @param bid
     */
    @Override
    public void updateSt(Integer bid) {
        List<Stock> st = (List<Stock>) stockMapper.selectByPrimaryKey(bid);

        //如果库存小于零
        if (st.size() < 0) {
            throw new RuntimeException();
        }
        //如果还有库存
        else {
            Stock stock = new Stock();
            stock.setSid(Integer.valueOf(bid));
            stock.setSt(Integer.valueOf(st.size() - 1));
            stockMapper.updateByPrimaryKey(stock);
        }

    }
}
