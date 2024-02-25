<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Add movie</title>
</head>
<body>
	<b>Please enter the movie info:</b>
	<form:form action="processMovie" modelAttribute="movie" method="post">

		<form:hidden path="id" />
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:textarea path="description" rows="5" cols="50" /></td>
			</tr>
			<tr>
				<td>Length:</td>
				<td><form:input path="length" type="number" /></td>
			</tr>

			<tr>
				<td>Year made:</td>
				<td><form:input path="year" /></td>
			</tr>
			<tr>
				<td>Release date:</td>
				<td><form:input path="releaseDate" /></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:select path="rating">
						<form:options items="${ratings }" />
					</form:select></td>
			</tr>
			<tr>
				<td>Total number of copies:</td>
				<td><form:input path="totalCopies" /></td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td><form:checkboxes path="genre" items="${genres	}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Movie" /></td>
			</tr>
		</table>

		<a class="btn btn-primary" href="${pageContext.request.contextPath}">Home</a>


	</form:form>
</body>
</html>