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


<style>
.left-align-table th, .left-align-table td {
	text-align: left;
	vertical-align: middle;
	word-wrap: break-word;
}

.left-align-table th:nth-child(7), .left-align-table td:nth-child(7) {
	max-width: 300px;
}

.left-align-table {
	width: 100%;
	margin-bottom: 20px;
}

.left-align-table th, .left-align-table td {
	border: 1px solid #dee2e6;
	padding: 8px;
}

.left-align-table th {
	background-color: #f5f5f5;
}

h2 {
	margin-bottom: 50px;
}
</style>

<title>Browse</title>
</head>
<body>
	<h2>Movies</h2>

	<form action="search" method="GET">
		<label for="keyword">Search movies:</label><br> <input
			type="text" id="keyword" name="searchTerms"><br> <label><input
			type="radio" name="searchType" value="title" checked> Title</label> <label><input
			type="radio" name="searchType" value="description">
			Description</label><br>
		<c:if test="${param.customerId ne null}">
			<input type="hidden" name="customerId" value="${param.customerId}" />
		</c:if>
		<button type="submit">Search</button>
	</form>

	<table class="left-align-table">
		<tr>
			<th>Title</th>
			<th>Year</th>
			<th>Length</th>
			<th>Genre</th>
			<th>Release date</th>
			<th>Rating</th>
			<th>Description</th>
			<th>Total copies</th>
			<th>Available copies</th>
		</tr>
		<c:forEach var="eachMovie" items="${movies }">
			<c:set var="buttonValue" value="Checkout" />
			<c:set var="checkoutId"
				value="${eachMovie.isCheckedOutByCustomer(param.customerId)}" />
			<c:if test="${checkoutId != 0}">
				<c:set var="buttonValue" value="Return movie" />
			</c:if>
			<form:form action="processCheckout" modelAttribute="checkout"
				method="post">
				<tr>
					<td>${eachMovie.title }</td>
					<td>${eachMovie.year }</td>
					<td>${eachMovie.length }minutes</td>
					<td>${eachMovie.genre }</td>
					<td>${eachMovie.releaseDate }</td>
					<td>${eachMovie.rating }</td>
					<td>${eachMovie.description }</td>
					<td>${eachMovie.totalCopies }</td>
					<td>${eachMovie.availableCopies }</td>
					<td><c:if
							test="${eachMovie.availableCopies > 0 and param.customerId ne null}">
							<form:hidden path="id" />
							<input type="hidden" name="checkoutId" value="${checkoutId}" />
							<input type="hidden" name="movieId" value="${eachMovie.id}" />
							<input type="hidden" name="customerId"
								value="${param.customerId}" />
							<input type="submit" value="${buttonValue }"
								class="btn btn-primary" />
						</c:if></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>

	<a class="btn btn-primary" href="${pageContext.request.contextPath}">Home</a>
</body>
</html>