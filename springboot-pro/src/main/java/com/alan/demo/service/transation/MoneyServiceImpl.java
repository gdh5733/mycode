package com.alan.demo.service.transation;

import com.alan.demo.mapper.MoneyMapper;
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
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyMapper moneyMapper;

    @Override
    public void update() {

    }
}
