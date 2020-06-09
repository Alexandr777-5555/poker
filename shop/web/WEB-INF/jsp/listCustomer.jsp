<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 07.06.2020
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>


<body>
<c:if test="${not empty customers }">
    <table border="1">
        <tr>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>


</html>
