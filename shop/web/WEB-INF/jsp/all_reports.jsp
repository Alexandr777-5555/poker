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
    <input type="text" name="bydate" value="${bydate}"/>
    <input type="submit" value="найти"/>
</form>


</body>
</html>
