package com.xuexiaotian.bookstore.entity;
/**
 * 购物车项
 */
public class ShoppingCartItem {

    private Book book;
    private int quantity; //购物某件商品的数量

    //定义的方法
    //获取购物项的金额
    public double getItemMoney(){
        return book.getPrice()*quantity;

    }
    //使商品数量+1
    public void increment(){
        this.quantity++;
    }

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    public ShoppingCartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
