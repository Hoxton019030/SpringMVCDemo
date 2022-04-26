<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增員工頁面</title>
</head>
<body>
<h1>新增員工頁面</h1>

      <!-- employee/add -->
<form:form action="add" modelAttribute="employeeBean" method="post">
   <form:input type="hidden" path="id"/>
   <br />
   請輸入姓名 <form:input path="name"/>
   <br />
   請輸入 Email <form:input path="email"/>
   <br />
   請輸入年資 <form:input type="number" min="0" max="90" path="jobAge"/>
   <br />
   
   <input type="submit" value="送出">
</form:form>



</body>
</html>