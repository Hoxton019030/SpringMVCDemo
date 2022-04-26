<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="carAction" modelAttribute="carBean" method="post">

brand: <form:input path="brand" />
<br />
color: <form:input path="color" />

<br />
出產國家

<!-- option 第一版 
<form:select path="country">
  <form:option value="GM" label="德國" />
  <form:option value="JP" label="日本" />
  <form:option value="KR" label="韓國" />
  <form:option value="USA" label="美國" />
</form:select>
-->

<!-- option 第二版(建構子) -->
<form:select path="country">
   <form:options items="${carBean.countryOptions}" />
</form:select>

<br />
車種(單選):
 <form:radiobutton path="carType" value="汽油車" />汽油車
 <form:radiobutton path="carType" value="電動車" />電動車
 <form:radiobutton path="carType" value="混合車" />混合(Hybrid)

<br />
<h3>多選(加裝設備)</h3>
 <form:checkbox path="addition" value="天窗" />天窗
 <form:checkbox path="addition" value="尾翼" />尾翼
 <form:checkbox path="addition" value="倒車雷達" />倒車雷達
<br />

<input type="submit" value="送出">
</form:form>

</body>
</html>