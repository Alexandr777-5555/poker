<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 15.05.2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>

<body>

<form method="post">
    <input type="text" name="owner" value="${owner}"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" class="btn btn-dark" value="найти"/>
</form>

 <table border="2" >

     <tr>
         <th>Имя пользователя</th>
         <th>Продукт</th>
         <th>Цена</th>
     </tr>

     <c:forEach items="${shopping}" var="shopcart">
         <tr>
             <td>${shopcart.owner}</td>
             <td>${shopcart.product.name}</td>
             <td>${shopcart.product.price}</td>
             <c:set var="amount" value="${amount+shopcart.product.price}"/>
         </tr>
     </c:forEach>
 </table>
<br>
<br>
общая стоимость покупок : ${amount}


<br>
<br>

<a href="${pageContext.request.contextPath}/">welcome</a>

</body>


</html>
