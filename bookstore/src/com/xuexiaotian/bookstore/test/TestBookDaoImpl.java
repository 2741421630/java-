package com.xuexiaotian.bookstore.test;

import com.xuexiaotian.bookstore.dao.BookDao;
import com.xuexiaotian.bookstore.dao.impl.BookDaoImpl;
import com.xuexiaotian.bookstore.entity.Book;
import com.xuexiaotian.bookstore.entity.ShoppingCartItem;
import com.xuexiaotian.bookstore.web.CriteriaBook;
import com.xuexiaotian.bookstore.web.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestBookDaoImpl {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void getBookById(){
        Book book = bookDao.getBookById(8);
        System.out.println(book);
    }

    @Test
    public void getPageList(){
        CriteriaBook cb = new CriteriaBook(50,70,2,3);
        List<Book> books = bookDao.getPageList(cb);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getPage(){
        CriteriaBook cb = new CriteriaBook(50,70,2,3);
        Page<Book> page = bookDao.getPage(cb);
        System.out.println("当前第"+page.getPageNo()+"页");
        System.out.println("每页显示"+page.getPageSize()+"条记录");
        System.out.println("共"+page.getTotalPageCount()+"页");
        System.out.println("共"+page.getTotalIteamCount()+"条记录");

        List<Book> books = page.getList();
       for (Book book :books){
           System.out.println(book);
       }
    }

    @Test
    public void getTotalBookCount(){
        CriteriaBook cb = new CriteriaBook(50,70,2,3);
        Long totalBookCount = bookDao.getTotalBookCount(cb);
        System.out.println(totalBookCount);
    }
    @Test
    public void batchUpdateStoreNumberAndSalesAmount() {
        Collection<ShoppingCartItem> items = new ArrayList<>();
        items.add(new ShoppingCartItem(bookDao.getBookById(1),10));
        items.add(new ShoppingCartItem(bookDao.getBookById(2),20));
        items.add(new ShoppingCartItem(bookDao.getBookById(3),30));
        items.add(new ShoppingCartItem(bookDao.getBookById(4),40));
        bookDao.batchUpdateStoreNumberAndSalesAmount(items);
    }
}









