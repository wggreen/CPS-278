<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info form</title>
<style type="text/css">
.error {
	color: red
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/myStyle.css">
</head>
<body>
	<div class="form-style-1">
		<form:form action="processForm" modelAttribute="customer">
			<form:label path="name">customer name:<span
					class="required">*</span>
			</form:label>
			<form:input path="name" />
			<form:errors path="name" cssClass="required"></form:errors>
			<br>
			<form:label path="age">customer age:
			</form:label>
			<form:input path="age" />
			<form:errors path="age" cssClass="error"></form:errors>
			<br>
			<form:label path="zipCode">customer zipcode:
			</form:label>
			<form:input path="zipCode" />
			<form:errors path="zipCode" cssClass="error"></form:errors>
			<br>
			<form:label path="favoriteCourse">Favorite course:
			</form:label>
			<form:input path="favoriteCourse" />
			<form:errors path="favoriteCourse" cssClass="error"></form:errors>
			<br>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>