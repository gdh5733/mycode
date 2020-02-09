package com.alan.demo.service;

import com.alan.demo.entity.Users;
import com.alan.demo.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/9
 */

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void createUsers(Users obj) {
        this.usersMapper.insertSelective(obj);
    }

    @Override
    public void updateUsers(Users obj) {
        this.usersMapper.updateByPrimaryKeySelective(obj);

    }

    @Override
    public void findExample() {
        log.info("--------------按主键查询: where id =1001---------------");
        Users user = (Users) this.usersMapper.selectByPrimaryKey(1001);
        log.info(user.toString());

        log.info("--------------按主键 查询: where sex =1   查出所有sex等于1的数据---------------");
        Users sex = new Users();
        sex.setSex((byte) 1);
        List<Users> list = this.usersMapper.select(sex);
        log.info("查询sex=1的条数,{}", list.size());
    }
}
