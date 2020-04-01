<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 08.03.2020
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>POKER STAT</title>
</head>
<body>

<h3>МЕНЮ</h3>

<li><h3><a href="view_winners">посмотреть список победителя</a></h3></li>
<br>
<br>
<li><h3><a href="view_winner_id">посмотреть победителя по id</a></h3></li>


<form method="post" >

<input type="submit" name="action-button" value="выполнить задачу"/>

</form>

</body>
</html>
