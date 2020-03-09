package com.alan.demo.service.transation;

import com.alan.demo.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateSt(String bid) {

    }
}
