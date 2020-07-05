<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 05.07.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex-container">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="menu"/>
    <article class="article">
        <tiles:insertAttribute name="body"/>
    </article>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
