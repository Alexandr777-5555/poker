<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: AVDEY
  Date: 05.07.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>

    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>

<table border="1" width="100%" >
    <tr>
        <td width="20%" colspan="2">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr >
        <td width="20%">
            <tiles:insertAttribute name="menu"/>
        </td>
        <td width="80%" >
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer"/>
        </td>
    </tr>


</table>

</body>
</html>
