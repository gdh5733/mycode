package com.alan.demo.controller.log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/16
 */


@Api(description = "测试Log接口")
@RequestMapping("/log")
@RestController
@Slf4j
public class LogController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试打印log到文件", notes = "测试log到文件")
    @GetMapping(value = "/logtest")
    public void login() {

        logger.info("这个是trace日志...");
        logger.debug("这个是dubug日志...");
    }


}
