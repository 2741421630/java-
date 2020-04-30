package com.xuexiaotian.bookstore.dao.impl;

import com.xuexiaotian.bookstore.dao.TradeDao;
import com.xuexiaotian.bookstore.entity.Trade;

import java.util.LinkedHashSet;
import java.util.Set;

public class TradeDaoImpl extends BaseDao<Trade> implements TradeDao {


    @Override
    public void insert(Trade trade) {
        String sql = "insert into trade (userid,tradetime) values(?,?)";
        //调用插入记录并返回自动生成的主键值
        long tradeId = insert(sql, trade.getUserId(), trade.getTradeTime());
        //将生成的主键值赋值给trade对象的id属性
        trade.setTradeId((int) tradeId);
    }

    @Override
    public Set<Trade> getTradesWithUserId(Integer userId) {
        String sql = "select tradeId,userId,tradeTime from trade where userid = ? order by tradeTime DESC";
        return new LinkedHashSet<>(getBeanList(sql,userId));
    }
}
