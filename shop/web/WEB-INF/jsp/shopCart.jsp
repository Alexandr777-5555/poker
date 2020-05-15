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
    <input type="submit" value="найти"/>
</form>

 <table border="2" >

     <tr>
         <th>Имя пользователя</th>
         <th>Продукт</th>
     </tr>

     <c:forEach items="${shopping}" var="shopcart">

         <tr>
             <td>${shopcart.owner}</td>
             <td>${shopcart.product.name}</td>
         </tr>

     </c:forEach>
 </table>

</body>


</html>
