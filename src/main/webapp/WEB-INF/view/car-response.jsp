<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car response</title>
</head>
<body>
<h1>Car response page</h1>

<h3>car: </h3>

<div>
${carBean.brand} and ${carBean.color}
</div>

<div>${carBean.country} 的汽車</div>

<div>車種: ${carBean.carType}</div>

<div>外加裝置</div>
<ul>
  <c:forEach var="item" items="${carBean.addition}">
     <li>${item}</li>
  </c:forEach>

</ul>


</body>
</html>