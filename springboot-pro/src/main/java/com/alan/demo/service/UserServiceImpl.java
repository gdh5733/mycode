package com.alan.demo.service;

import com.alan.demo.mapper.TInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/18
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TInfoMapper userMapper;

    @Override
    public String selectTeleByid(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return userMapper.selectTeleByid(map);

    }
}
