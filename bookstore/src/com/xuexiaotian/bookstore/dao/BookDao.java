package com.xuexiaotian.bookstore.dao;

import com.xuexiaotian.bookstore.entity.Book;
import com.xuexiaotian.bookstore.entity.ShoppingCartItem;
import com.xuexiaotian.bookstore.web.CriteriaBook;
import com.xuexiaotian.bookstore.web.Page;

import java.util.Collection;
import java.util.List;

public interface BookDao {


   //获取指定id的图书
    Book getBookById(Integer id);

    //根据查询条件获取某一页上要显示的书的集合
    List<Book> getPageList(CriteriaBook cb);

    //根据查询条件获取书的总记录
     Long getTotalBookCount(CriteriaBook cb);

  //根据查询条件获取某一页的Page<Book>类的对象
   Page<Book> getPage(CriteriaBook cb);
   //批量更新books表中的库存和销售数量
    void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);

}
