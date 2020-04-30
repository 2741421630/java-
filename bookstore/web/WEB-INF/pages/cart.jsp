<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/16
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>

 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>您的购物车</title>
     <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
     <script type="text/javascript">
         $(function () {
             //单击a标签时，执行以下操作
             $("a").click(function () {
                 var serializeVal =  $(":hidden").serialize();
                 var href = this.href + "&" + serializeVal;
                 window.location.href = href;
                 return false;
             });
             $(":text").change(function () {
                 //获取文本输入框的值
                 var quantityVal = $.trim(this.value);
                 var quantity = -1;
                 var reg = /^\d+$/g;
                 var flag = false;
                 //101,正则检验，过滤数组的值，进行转换
                 if (reg.test(quantityVal)){
                     //类型转换
                     quantity = parseInt(quantityVal);
                     //-3，非负数的检验
                     if (quantity>=0){
                         flag = true;
                     }
                 }
                 if (!flag){
                     alert("您输入的数值不合理，请重新输入");
                     //恢复原值
                     $(this).val($(this).attr("class"));
                 }

                 var $tr = $(this).parent().parent();
                 var title = $.trim($tr.find("td:first").text());
                 //如果修改的数量==0，相当于删除购物项
                 if (quantity==0){
                     var flag2 = confirm("确定要删除"+title+"吗?");
                     if (flag2){
                         var href = $tr.find("td:last").find("a").attr("href");
                         var serializeVal =  $(":hidden").serialize();
                         href = href + "$" + serializeVal;
                         window.location.href = href;
                         return;
                     }else{
                         //恢复原值
                         $(this).val($(this).attr("class"));
                     }
                 }
                 //如果修改的数量>0，相当于修改购物车的属性
                 //输入的值>0的整数，发送ajax请求，得到数量，更新页面的局部区域
                 flag = confirm("确定要修改"+title+"的数量吗?");
                 if (!flag){
                     //恢复原值
                     $(this).val($(this).attr("class"));
                     return;
                 }
                 //发送ajax请求，得到数量，更新页面的局部区域.
                 var url = "bookServlet";
                 var idVal = $.trim(this.name);
                 var args = {"method":"updateItemQuantity","id":idVal,"quantity":quantity,"time":new Date()};
                 $.post(url,args,function (data) {//
                     var bookNumber = data.bookNumber;
                     var totalMoney = data.totalMoney;

                     //更新
                     $("#bookNumber").text(bookNumber);
                     $("#totalMoney").text(totalMoney);

                 },"JSON");
             });
         })

     </script>

 </head>
 <body>
 <%--使用隐藏域来存储表单提交的数据--%>
 <input type="hidden" name="minPrice" value="${param.minPrice}">
 <input type="hidden" name="maxPrice" value="${param.maxPrice}">
 <input type="hidden" name="pageSize" value="${param.pageSize}">


 <center>
     <br>
     <br>

     您的购物车中有<span id="bookNumber">${sessionScope.ShoppingCart.bookNumber}</span>本书.<br><br>
     <table cellspacing="10" cellpadding="0">
         <tr>
             <th>图书名称</th>
             <th>图书数量</th>
             <th>图书价格</th>
             <th>&nbsp;</th>
         </tr>

         <c:forEach items="${sessionScope.ShoppingCart.items }" var="item">
             <tr>
                 <td>${item.book.title}</td>
             <td>
         <input type="text"
                        size="1"
                        value="${item.quantity}"
                        name="${item.book.id}"
                        class="${item.quantity}">
             </td>
             <td>${item.book.price}</td>
             <td><a href="bookServlet?method=removeItem&id=${item.book.id}&pageNo=${param.pageNo}">删除</a></td>
             </tr>
         </c:forEach>
         <tr>
             <td colspan="4">
                 总金额为¥<span id="totalMoney">${sessionScope.ShoppingCart.totalMoney}</span>元
             </td>
         </tr>
         <tr>
             <td colspan="4">
                 <a href="bookServlet?method=getBooks&pageNo=${param.pageo}">继续浏览</a>&nbsp;&nbsp;
                 <a href="bookServlet?method=clearCart&pageNo=${param.pageNo}">清空购物车</a>&nbsp;&nbsp;
                 <a href="bookServlet?method=toCashPage&pageNo=${param.pageNo}">结账</a>&nbsp;&nbsp;
             </td>
         </tr>
     </table>

     <br>
     <br>
 </center>


 </body>
 </html>
