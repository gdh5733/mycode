
package com.alan.demo.utils.设计模式.动态代理;

import com.alan.demo.utils.设计模式.动态代理.IUserService;

/**
 * @Description User实现类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/3
 */

public class UserServiceImpl implements IUserService {


    @Override
    public String findUser(String id) {

        return "查询数据库找到这些数据" + id;
    }
}
