<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info form</title>
</head>
<body>
	<h2>
		${customerName }<br> Please customize your pizzas:
	</h2>
	<form:form action="addPizza" modelAttribute="newPizza">
		<table>
			<tr>
				<td>Pick the size:</td>
				<td><form:radiobuttons path="size" items="${sizeList }" /> <br>
				</td>
			</tr>
			<tr>
				<td>Pick the toppings:</td>
				<td><form:radiobuttons path="topping" items="${toppingList }" /> <br>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add pizza to cart" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>