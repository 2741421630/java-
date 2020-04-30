package com.xuexiaotian.bookstore.web;

import com.xuexiaotian.bookstore.entity.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookStoreWebUtils {
    /**
     * 从session获取购物车对象
     * 如果没有:创建购物车对象,并存入Session
     * 如果有,则正常返回
     */
    public static ShoppingCart getShoppingCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
        if (sc == null) {
            sc = new ShoppingCart();
            session.setAttribute("ShoppingCart",sc);
        }
        return sc;
    }
}

















