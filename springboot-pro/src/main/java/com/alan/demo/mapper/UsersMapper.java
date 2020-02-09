package com.alan.demo.mapper;

import com.alan.demo.entity.Users;
import com.alan.demo.entity.UsersExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);


    /**
     * 不管有没有数都插入
     *
     * @param record
     * @return
     */
    int insert(Users record);

    /**
     * 有数据才插入
     *
     * @param record
     * @return
     */
    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}