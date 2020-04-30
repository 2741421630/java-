package com.xuexiaotian.bookstore.test;

import com.xuexiaotian.bookstore.dao.AccountDao;
import com.xuexiaotian.bookstore.dao.impl.AccountDaoImpl;
import com.xuexiaotian.bookstore.entity.Account;
import org.junit.Test;

public class AccountDaoImplTest {

    private AccountDao accountDao = new AccountDaoImpl();

   @Test
   public void getAccountById() {
       Account account = accountDao.getAccountById(1);
       System.out.println(account);
   }

   @Test
   public void updateBalance() {
       accountDao.updateBalance(1,5000);
       Account account = accountDao.getAccountById(1);
       System.out.println(account);
   }
}