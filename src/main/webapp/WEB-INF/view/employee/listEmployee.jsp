<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var ="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${contextRoot}/css/emplist.css">
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
		</tr>

		<c:forEach var="oneEmployee" items="${employeeList}">
			<tr>
				<th>${oneEmployee.id}</th>
				<th>${oneEmployee.name}</th>
				<th>${oneEmployee.email}</th>
				<th>${oneEmployee.jobAge}</th>
				<td><a href="${contextRoot}/employee/editemployee?id=${oneEmployee.id}">編輯</a></td>
				<td><a href="${contextRoot}/employee/deleteEmp?id=${oneEmployee.id}">刪除</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>