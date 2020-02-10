package com.alan.demo.service;

import com.alan.demo.entity.Users;
import com.alan.demo.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
        Users user = (Users) this.usersMapper.selectByPrimaryKey(5942);
        log.info(user.toString());

        log.info("--------------按主键 查询: where sex =1   查出所有sex等于1的数据---------------");
        Users sex = new Users();
        sex.setSex((byte) 1);
        List<Users> list = this.usersMapper.select(sex);
        log.info("查询sex=1的条数,{}", list.size());


        log.info("--------------查询: where username=? and password=? ---------------");
        Users user1 = new Users();
        user1.setUsername("user944");
        user1.setPassword("user944");
        Users obj = (Users) this.usersMapper.selectOne(user1);
        log.info("返回的数据值为: ", obj.toString());


        log.info("-----Example.Criteria查询: where username? and password=?------------------");
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", "user944");
        criteria.andEqualTo("password", "user944");

        List<Users> objs = this.usersMapper.selectByExample(example);
        log.info("Example.Criteria查询结果,{}", objs.toString());


        log.info("-----Example.Criteria 模糊查询: where username like? and password like ?------------------");
        example = new Example(Users.class);
        criteria = example.createCriteria();
        criteria.andLike("username", "%100%");
        objs = this.usersMapper.selectByExample(example);
        log.info("Example.Ctriteria查询结果,{}", objs.toString());

        log.info("-----Example.Criteria 排序: where username like? and order by id desc ?------------------");
        example = new Example(Users.class);
        example.setOrderByClause("id desc ");
        criteria = example.createCriteria();
        criteria.andLike("username", "%100%");
        objs = this.usersMapper.selectByExample(example);
        log.info("Example.Criteria查询结果,{}", objs.toString());

        log.info("------------------------Example.Criteria in 查询: where id in(1,2)? ----------------");
        example = new Example(Users.class);
        criteria = example.createCriteria();
        List ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        criteria.andIn("id", ids);
        objs = this.usersMapper.selectByExample(example);
        log.info("Example.Criteria查询结果,{}", objs.toString());


        log.info("------------------分页查询1---------------");

        Users obj2 = new Users();
        obj2.setSex((byte) 1);
        int count = this.usersMapper.selectCount(obj2);
        log.info("分页例子: 总条数{}", count);

        objs = this.usersMapper.selectByRowBounds(obj2, new RowBounds(0, 10));

        for (Users u : objs) {
            log.info("分页例子: 第一页{}", u.toString());
        }


        log.info("------------------分页查询2---------------------");
        example = new Example(Users.class);
        criteria = example.createCriteria();
        criteria.andEqualTo("sex", 1);
        count = this.usersMapper.selectCountByExample(example);
        log.info("分页例子: 总条数{}", count);
        objs = this.usersMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 10));
        for (Users u : objs) {
            log.info("分页例子: 第一页{}", u.toString());
        }
    }
}
