package com.alan.demo.service;

import com.alan.demo.entity.Users;
import com.alan.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */


@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void createUsers(Users obj) {
        usersMapper.insertSelective(obj);
    }

    @Override
    public void updateUsers(Users obj) {

    }
}
