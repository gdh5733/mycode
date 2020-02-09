package com.alan.demo.service;


import com.alan.demo.entity.Users;

public interface UsersService {


    /**
     * 创建用户
     *
     * @param obj
     */
    public void createUsers(Users obj);


    /**
     * 更新用户
     *
     * @param obj
     */
    public void updateUsers(Users obj);


    public void findExample();
}
