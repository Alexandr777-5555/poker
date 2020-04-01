<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 01.04.2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">

    <input type="number" name="numberID" value="${numberId}">
    <input type="submit" value="показать">

</form>


<table border="2">
    <tr>
        <th>PLAYER</th>
        <th>CHIPS</th>
    </tr>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${player.id} </td>
            <td>${player.chips}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
