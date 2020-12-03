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
	<h1 align="center">Provide User Information</h1>
	<hr/>
	<form:form action="submitDetails" modelAttribute="user">
		<table border="1" align="center">
			<form:hidden path="id"/>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<form:radiobutton path="gender" value="male"/>Male&nbsp;
					<form:radiobutton path="gender" value="female"/>Female
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<form:select path="state">
						<form:option value="Maharashtra">Maharashtra</form:option>
						<form:option value="Gujarat">Gujarat</form:option>
						<form:option value="Tamil Nadu">Tamil Nadu</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td>
					<form:input path="phoneno"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Submit"/>&nbsp;
					<input type="reset" value="Reset"/>
				</td>
			</tr>
		</table>
	</form:form>
	<hr/>
	<a href="listUsers">Go To Users Lists</a>
</body>
</html>