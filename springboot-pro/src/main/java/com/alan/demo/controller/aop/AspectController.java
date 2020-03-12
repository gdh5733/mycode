package com.alan.demo.controller.aop;
import com.alan.demo.utils.spring.aop.AOP3.ArithmeticCalculator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 利用Aspect框架实现切面编程
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

@Api(description = "测试Aspect接口")
@RequestMapping("/Aspect")
@RestController
@Slf4j
public class AspectController {

    @Autowired
    ArithmeticCalculator arithmeticCalculator;

    Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试Aspect框架", notes = "测试Aspect框架")
    @GetMapping(value = "/Asp")
    public void Asp() {

        logger.info("利用aop执行2+3开始");
        arithmeticCalculator.add(2, 3);

        logger.info("利用aop执行3*4开始");
        arithmeticCalculator.mul(3, 4);
    }
}
