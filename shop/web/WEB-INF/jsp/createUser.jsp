<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 29.05.2020
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>create user</title>
</head>
<body>
<form:form method="post" modelAttribute="customer">
    <form:errors path="*" cssClass="errors"/>

    <table>
        <tr>
            <td>Имя</td>
            <td><form:input path="firstName"/></td>
            <td><form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><form:input path="lastName"/></td>
            <td><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Дата рождения</td>
            <td><form:input path="dateOfBirth"/></td>
            <td><form:errors path="dateOfBirth" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
