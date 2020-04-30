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
    <title>购物成功页面</title>
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
         })

     </script>
 </head>
 <body>

 <%--使用隐藏域来存储表单提交的数据--%>
 <input type="hidden" name="minPrice" value="${param.minPrice}">
 <input type="hidden" name="maxPrice" value="${param.maxPrice}">
 <input type="hidden" name="pageSize" value="${param.pageSize}">
 <input type="hidden" name="pageNo" value="${param.pageNo}">
 <center>
     <br>
     <br>
     <h2>购物成功</h2>
     <br>
     <br>
     <a href="bookServlet?method=getBooks">返回图书列表</a>

 </center>
 </body>
 </html>
