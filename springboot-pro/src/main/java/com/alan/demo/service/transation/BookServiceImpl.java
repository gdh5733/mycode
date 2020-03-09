package com.alan.demo.service.transation;

import com.alan.demo.mapper.BookMapper;
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
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 通过书的编号查询书的价格
     *
     * @param id
     */
    @Override
    public void selectPrice(String id) {

    }
}
