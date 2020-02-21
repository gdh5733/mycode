package com.alan.demo.controller.thymeleaf;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/16
 */
@Api(description = "测试thymeleaf接口")
@RequestMapping("/thy")
@Controller
@Slf4j
public class thymeleafController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试打印log到文件", notes = "测试log到文件")
    @GetMapping(value = "/thr")
    public String login() {

        Map<String, String> map = new HashMap<>();
        map.put("hello", "hello");
        logger.info("数据处理完成,返回给前端");
        return "success";
    }
}
