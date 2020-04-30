package com.xuexiaotian.bookstore.dao;

import com.xuexiaotian.bookstore.entity.User;

public interface UserDao {

    //根据用户名获取user对象
    User getUserByUsername(String username);
}
