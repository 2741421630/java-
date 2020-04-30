package com.xuexiaotian.bookstore.dao;

import com.xuexiaotian.bookstore.entity.Trade;

import java.util.Set;

public interface TradeDao {
    //向数据trade中添加一条记录
    void insert(Trade trade);
    //根据userId获取相关的Trade集合
    Set<Trade> getTradesWithUserId(Integer userId);
}
