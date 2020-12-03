<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">List Of Users</h1>
<hr/>
	<table border="1" align="center">
		<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>State</th>
			<th>Phone No</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${list}" var="user">
		<c:url var="updateLink" value="showUpdateForm">
			<c:param name="userId" value="${ user.id }"></c:param>
		</c:url>
		<c:url var="deleteLink" value="deleteRecord">
			<c:param name="userId" value="${ user.id }"></c:param>
		</c:url>
		<tr>
			<td>${ user.name }</td>
			<td>${ user.gender }</td>
			<td>${ user.state }</td>
			<td>${ user.phoneno }</td>
			<td><a href="${ updateLink }">Update</a> | <a onclick="if(!(confirm('Are You Sure You Want To DeleteThis Record ?'))) return false" href="${ deleteLink }">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
<hr/>
<p align="center"><button onclick="window.location.href = 'addUser'"; return false;>Add User</button></p>
</body>
</html>