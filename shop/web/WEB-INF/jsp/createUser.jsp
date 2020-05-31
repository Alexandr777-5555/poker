<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 29.05.2020
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>
</head>
<body>


<form:form method="post" modelAttribute="customer">

    <table>
        <tr>
            <td>Имя</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><form:input path="lastName"/></td>

        </tr>
        <tr>
            <td>Дата рождения</td>
            <td><form:input path="dateOfBirth"/></td>
        </tr>


        <tr>
            <td><input type="submit"/> </td>

        </tr>

    </table>


</form:form>


</body>
</html>
