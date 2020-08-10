<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 12.06.2020
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="mx-auto my-2 my-sm-3 my-lg-4 p-3">
    <table border="1">
        <form method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <tr>
                <th>find by date</th>
                <th><input type="text" placeholder="yyyy-mm-dd" name="bydate" value="${bydate}"/></th>

            </tr>
            <td></td>
            <td><input type="submit" class="btn btn-dark" value="найти"/></td>
        </form>
    </table>
</div>
<br>
<br>


</body>
</html>
