<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改員工資料</title>
</head>
<body>
<h1>修改資料頁面</h1>

<form:form action="editpost" modelAttribute="employeeBean" method="post">
   <form:input type="hidden" path="id"/>
   <br />
   姓名 <form:input path="name"/>
   <br />
   Email <form:input path="email"/>
   <br />
   年資 <form:input type="number" min="0" max="90" path="jobAge"/>
   <br />
   
   <input type="submit" value="送出">
</form:form>

</body>
</html>