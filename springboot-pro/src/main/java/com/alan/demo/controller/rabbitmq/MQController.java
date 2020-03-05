package com.alan.demo.controller.rabbitmq;

import com.alan.demo.service.rabbitmq.Send;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/5
 */


@Api(description = "rabbitmq接口")
@RestController
@Slf4j
public class MQController {

    @Autowired
    Send send;

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public void demo1() {

        this.send.send();
    }

}
