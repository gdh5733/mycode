package com.alan.demo.service.transation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 结账实现类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/9
 */

@Transactional
@Service
public class CashiesServiceImpl implements CashierService {

    @Autowired
    BookService bookService;

    @Override
    public void checkout(Integer bid, Integer uid, List<Integer> bids) {
        for (int i = 1; i <= bids.size(); i++) {
            bookService.buyBook(bid, String.valueOf(uid), 1);
        }
    }
}
