<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>

	<h1>New Dojo</h1>

	<p>
		<a href="/ninjas/new">Create Ninja</a>
	</p>

	<form:form action="/dojos/new" method="post" modelAttribute="dojo">

		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" style="color:red;" />
		</div>

		<br>

		<button type="submit">Create</button>

	</form:form>

</body>
</html>