package com.xuexiaotian.bookstore.service;

import com.xuexiaotian.bookstore.dao.*;
import com.xuexiaotian.bookstore.dao.impl.*;
import com.xuexiaotian.bookstore.entity.*;
import com.xuexiaotian.bookstore.web.BookStoreWebUtils;
import com.xuexiaotian.bookstore.web.CriteriaBook;
import com.xuexiaotian.bookstore.web.Page;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

//处理关于book的业务层
public class BookService {

    private BookDao bookDao = new BookDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();
    private TradeDao tradeDao = new TradeDaoImpl();
    private TradeItemDao tradeItemDao = new TradeItemDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public Page<Book> getBooks(CriteriaBook cb) {
        return bookDao.getPage(cb);
    }

     public Book getBookById(int id) {
       return bookDao.getBookById(id);
     }

     public void clearCart(ShoppingCart shoppingCart) {
        shoppingCart.getItems().clear();
     }

     public void removeItemFromShoppingCart(ShoppingCart sc, int id) {
        sc.removeItemById(id);
     }

     public void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
        sc.updateItemQuantity(id,quantity);
     }

     //执行结账操作
     public void cash(HttpServletRequest request, String username, String accountIdStr) {
         ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(request);

         //1.批量更新myBooks表中的销量和库存
         bookDao.batchUpdateStoreNumberAndSalesAmount(shoppingCart.getItems());
         //2.更新account表中的余额
         accountDao.updateBalance(Integer.parseInt(accountIdStr),shoppingCart.getTotalMoney());
         //3.向交易表中添加一条记录
         Trade trade = new Trade();
         trade.setTradeTime(new Date(new java.util.Date().getTime()));
         trade.setUserId(userDao.getUserByUsername(username).getUserId());

         tradeDao.insert(trade);
         //4.向交易详情表批量添加多条交易详情的记录
         Collection<TradeItem> items = new ArrayList<>();
         for (ShoppingCartItem sci : shoppingCart.getItems()) {
             TradeItem tradeItem = new TradeItem();
             tradeItem.setBookId(sci.getBook().getId());
             tradeItem.setQuantity(sci.getQuantity());
             tradeItem.setTradeId(trade.getTradeId());
             items.add(tradeItem);
         }
         tradeItemDao.batchSave(items);
         //5.清空购物车
         shoppingCart.getBooks().clear();
     }
 }
