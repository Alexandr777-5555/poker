<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 06.07.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>
    <h6> hello ${pageContext.request.remoteUser} </h6>
    <form action="<c:url value="/logout"/>" method="post">
        <%--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <button>Logout</button>
    </form>
</footer>
