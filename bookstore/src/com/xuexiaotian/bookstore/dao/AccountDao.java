package com.xuexiaotian.bookstore.dao;

import com.xuexiaotian.bookstore.entity.Account;

public interface AccountDao {

    //根据id获取Account对象
    Account getAccountById(Integer accountId);
    //根据传入accountId,和要更新的钱数来扣除账户的余额
    void updateBalance(Integer accountId,double amount);
}
