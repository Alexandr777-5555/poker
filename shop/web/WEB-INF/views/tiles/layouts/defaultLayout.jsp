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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<table border="1" width="100%" >
    <tr>
        <td width="20%" colspan="2">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr>
        <td width="20%" >
            <tiles:insertAttribute name="menu"/>
        </td>
        <td width="80%" height="500px" >
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
