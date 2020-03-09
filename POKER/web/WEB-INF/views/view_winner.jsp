<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 09.03.2020
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <h4>список победителей</h4>

<c:if test="${not empty players }">

      <table border="1">
            <tr>
                <td>Player id</td>
                <td>Player amount chips</td>
            </tr>
          <c:forEach var="player" items="${players}">
            <tr>
              <td>${player.id}</td>
              <td>${player.chips}</td>
            </tr>
          </c:forEach>
      </table>
</c:if>




</body>
</html>
