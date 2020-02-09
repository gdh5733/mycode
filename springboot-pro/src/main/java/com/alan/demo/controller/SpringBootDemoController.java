package com.alan.demo.controller;

import com.alan.demo.entity.TInfo;
import com.alan.demo.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description 测试日志框架
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/21
 */

@Api(description = "springboot常用功能接口")
@RestController
@Slf4j
public class SpringBootDemoController {


    @Autowired
    private ScoreService scoreService;
    int a = 2;

    /**
     * 测试swagger
     *
     * @return
     */
    @ApiOperation("测试swagger")
    @GetMapping("/home")
    public String name() {
        return "hello word!";
    }

    /**
     * 测试log
     */
    @ApiOperation("测试log方法")
    @GetMapping("/log")
    public void log() {
        log.trace("-----trace------");
        log.debug("---debug---");
        log.error("---error---");
        log.info("----info---");
        log.warn("---warn---");
    }

    /**
     * 测试异步
     * 此异步线程  没执行一个异步 就新建一个线程
     *
     * @return
     */
    @ApiOperation("测试异步")
    @RequestMapping("/sync")
    public ResponseEntity<TInfo> createUser() {
        log.info("--------------注册用户--------------");
        this.scoreService.addScore();
        TInfo bean = new TInfo();
        bean.setId(1);
        bean.setTelephone("17614099818");
        bean.setUserAddress("吉林辽源");
        return ResponseEntity.ok().body(bean);
    }


    @ApiOperation(value = "测试异步方法二", notes = "此异步使用自定义线程池")
    @RequestMapping(value = "/sync1", method = RequestMethod.GET)
    public ResponseEntity<String> createUser1() throws InterruptedException {
        log.info("--------------注册用户--------------");
        this.scoreService.addScor2();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ok");

    }


}
