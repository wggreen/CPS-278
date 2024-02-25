<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
.btn-group {
	margin-bottom: 10px;
	display: block;
}

.btn-group a {
	display: block;
	width: 150px;
	text-align: center;
	margin-bottom: 5px;
}
</style>

<title>Home</title>
</head>
<body>
	<div class="container">
		<h2>Admin Tools</h2>
		<ul>
			<li class="btn-group"><a class="btn btn-primary" href="newMovie">Add
					a new movie</a></li>
			<li class="btn-group"><a class="btn btn-primary" href="browse">Browse
					movies</a></li>
		</ul>
		<hr />
		<h2>Login</h2>
		<ul>
			<c:forEach var="eachCustomer" items="${customers}">
				<li class="btn-group"><a class="btn btn-primary"
					href="${pageContext.request.contextPath}/customer?customerId=${eachCustomer.id}">
						Login as ${eachCustomer.name} </a></li>
			</c:forEach>

		</ul>
	</div>
</body>
</html>