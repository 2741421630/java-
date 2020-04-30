package com.xuexiaotian.bookstore.service;


import com.xuexiaotian.bookstore.dao.UserDao;
import com.xuexiaotian.bookstore.dao.impl.UserDaoImpl;
import com.xuexiaotian.bookstore.entity.User;

public class UserService {
  private UserDao userDao = new UserDaoImpl();


    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
