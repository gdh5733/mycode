package com.alan.demo.controller.transtation;

import com.alan.demo.service.transation.BookService;
import com.alan.demo.service.transation.CashierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/9
 */
@Api(description = "测试Spring事务接口")
@RestController
@RequestMapping("/tx-controller")
public class TxController {

    @Autowired
    BookService bookService;

    @Autowired
    CashierService cashierService;


    Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试买书", notes = "测试买书(事务传播机制)")
    @GetMapping(value = "/buybook")
    public void buybook(@RequestParam(value = "bid", required = false) Integer bid,
                        @RequestParam(value = "uid", required = false) String uid,
                        @RequestParam(value = "count", required = false) Integer count) {

        bookService.buyBook(bid, uid, count);
    }


    @ApiOperation(value = "测试买书(事务传播机制)", notes = "测试买书(事务传播机制)")
    @GetMapping(value = "/cashier")
    public void cashier(@RequestParam(value = "bid", required = false) Integer bid,
                        @RequestParam(value = "uid", required = false) Integer uid
    ) {

        List<Integer> count = new ArrayList<>();
        count.add(1);
        count.add(1);
        count.add(1);
        cashierService.checkout(bid, uid, count);
    }
}
