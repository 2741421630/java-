package com.xuexiaotian.bookstore.dao;

import com.xuexiaotian.bookstore.entity.TradeItem;

import java.util.Collection;
import java.util.Set;

public interface TradeItemDao {
    //批量保存TradeItem对象,一次添加多个交易详情项
    void batchSave(Collection<TradeItem> items);
    //根据tradeId获取其关联TradeItem对象的集合
    Set<TradeItem> getTradeItemWithTradeId(Integer tradeId);


}
