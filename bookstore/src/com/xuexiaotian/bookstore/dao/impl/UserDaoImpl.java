package com.xuexiaotian.bookstore.dao.impl;

import com.xuexiaotian.bookstore.dao.UserDao;
import com.xuexiaotian.bookstore.entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {


    @Override
    public User getUserByUsername(String username) {

        String sql = "select userId,username,accountId from userinfo where username = ?";
        return getBean(sql,username);
    }
}
