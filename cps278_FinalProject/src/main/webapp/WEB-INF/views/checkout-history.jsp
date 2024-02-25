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

.btn-group {
	display: block;
	margin-bottom: 10px;
}
</style>

<title>Checkout history</title>
</head>
<body>
	<h2>${customerName }</h2>

	<table class="left-align-table">
		<tr>
			<th>Movie title</th>
			<th>Checkout date</th>
			<th>Return date</th>
		</tr>
		<c:forEach var="eachCheckout" items="${checkouts }">
			<form:form action="processCheckout" modelAttribute="checkout"
				method="post">
				<tr>
					<td>${eachCheckout.movie.title }</td>
					<td>${eachCheckout.checkoutDate }</td>
					<td>${eachCheckout.returnDate }</td>
					<td><c:if test="${eachCheckout.returnDate eq null}">
							<input type="hidden" name="checkoutId"
								value="${eachCheckout.id }" />
							<input type="hidden" name="customerId"
								value="${eachCheckout.customer.id }" />
							<input type="hidden" name="movieId"
								value="${eachCheckout.movie.id }" />
							<input type="submit" value="Return Movie" class="btn btn-primary" />
						</c:if></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>

	<div class="btn-group">
		<a
			href="${pageContext.request.contextPath}/browse?customerId=${customerId}"
			class="btn btn-primary">Checkout movies</a>

	</div>

	<div class="btn-group">
		<a href="${pageContext.request.contextPath}" class="btn btn-primary">Home</a>
	</div>

</body>
</html>