<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有員工</title>
<link rel="stylesheet" href="${contextRoot}/css/empList.css" >
</head>
<body>
<h1>全員工列表</h1>


<table>
<tr>
  <th>id</th>
  <th>姓名</th>
  <th>Email</th>
  <th>年資</th>
  <th>編輯</th>
  <th>刪除</th>
</tr>

  <c:forEach var="oneEmployee" items="${employeeList}">
  <tr>
	  <td>${oneEmployee.id}</td>
	  <td>${oneEmployee.name}</td>
	  <td>${oneEmployee.email}</td>
	  <td>${oneEmployee.jobAge}</td>
	  <td><a href="${contextRoot}/employee/editemployee?id=${oneEmployee.id}">編輯</a></td>
	  <td><a href="${contextRoot}/employee/deleteEmp?id=${oneEmployee.id}">刪除</a> </td>
  </tr>
 </c:forEach>
</table>

</body>
</html>