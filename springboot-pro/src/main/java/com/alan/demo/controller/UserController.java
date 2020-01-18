package com.alan.demo.controller;

import com.alan.demo.service.TestService;
import com.alan.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/17
 */

@Api(description = "用户操作接口")
@Controller("user")
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @ApiOperation(value = "获取电话号", notes = "通过id获取电话号")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "getTele", method = RequestMethod.GET)
    @ResponseBody
    public String getTele(@RequestParam(name = "id") String id) {

        String tele = userService.selectTeleByid(id);
        return tele;

    }


    @ApiOperation(value = "测试第一种自定义系统初始化器", notes = "测试第一种自定义系统初始化器")
    @RequestMapping(value = "testFirstInitializer", method = RequestMethod.GET)
    @ResponseBody
    public String testFirst() {

        return testService.test();

    }

    @RequestMapping(value = "/hellosentence",method = RequestMethod.GET)
    @ResponseBody
    public String hellosentence(){
        String sentence = "Hello World";
        return sentence;
    }


}

