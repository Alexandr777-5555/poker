<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 12.06.2020
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <tx>
        <td>find by date</td>
        <td><input type="text" name="bydate" value="${bydate}"/></td>
    </tx>
    <td></td>
    <td><input type="submit" value="найти"/></td>
</form>


</body>
</html>
