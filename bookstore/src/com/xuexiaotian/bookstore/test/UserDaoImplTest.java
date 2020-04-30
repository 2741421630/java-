package com.xuexiaotian.bookstore.test;


import com.xuexiaotian.bookstore.dao.UserDao;
import com.xuexiaotian.bookstore.dao.impl.UserDaoImpl;
import com.xuexiaotian.bookstore.entity.User;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDao userDao= new UserDaoImpl();

  @Test
  public void getUserByUsername() {
      User user = userDao.getUserByUsername("AAA");
      System.out.println(user);


  }
}