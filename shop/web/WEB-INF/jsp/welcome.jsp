<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>

</head>


<body>

<H3>Начало разработки проекта "корзина покупателя" </H3>



<a href="shopCart">поиск покупок по держателю карты</a>
<br>
<a href="calculateCart">общая стоимость покупок</a>

 <br>

  <h5>${totalTime} mc </h5>


  <h5>язык отображения  : ${pageContext.response.locale}</h5>

  <h5> <spring:message code=" "  />  : ${pageContext.response.locale}</h5>






</body>

</html>