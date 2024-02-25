<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addStudent" method="post">
		<input type="submit" value="Add Student" />
	</form>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="eachStudent" items="${students }">
			<c:url var="updateLink" value="/student/updateStudent">
				<c:param name="studentId" value="${eachStudent.id }" />
			</c:url>
			<c:url var="deleteLink" value="/student/deleteStudent">
				<c:param name="studentId" value="${eachStudent.id }" />
			</c:url>
			<tr>
				<td>${eachStudent.firstName }</td>
				<td>${eachStudent.lastName }</td>
				<td>${eachStudent.email }</td>
				<td><a href="${updateLink }">Update</a></td>
				<td><a href="${deleteLink }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>