package com.xuexiaotian.bookstore.service;

import com.xuexiaotian.bookstore.dao.AccountDao;
import com.xuexiaotian.bookstore.dao.impl.AccountDaoImpl;
import com.xuexiaotian.bookstore.entity.Account;

public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();
    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
    }
}
