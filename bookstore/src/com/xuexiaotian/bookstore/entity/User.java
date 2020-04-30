package com.xuexiaotian.bookstore.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 用户类
 */
public class User {

    private Integer userId;
    private String userName;
    private Integer accountId;

    //一个用户拥有多个交易记录
    private Set<Trade> trades = new LinkedHashSet<>();
    //一个用户关联一个账户
    private Account account;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", accountId=" + accountId +
                '}';
    }

    public User() {
    }

    public User(Integer userId, String userName, Integer accountId) {
        this.userId = userId;
        this.userName = userName;
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
