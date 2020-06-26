<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 07.06.2020
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css">

    <spring:url value="/listCustomer/list/pdf" var="pdfLink" />
</head>

<body>
<c:if test="${not empty customers }">
    <table class="ui celled table">
        <thead>
        <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th class="two wide">DEL</th>
        </tr>
        </thead>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>
                    <c:url value="/listCustomer/${customer.id}" var="deleteUrl"/>
                    <form action="${deleteUrl}" method="post" style="float: left;">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <button class="ui mini axis-tick-mark icon button"><i class="remove circle icon"></i></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<br>
<a href="${pageContext.request.contextPath}/">welcome</a>

<br>

<h5>${totalTime} mc </h5>

</body>
</html>
