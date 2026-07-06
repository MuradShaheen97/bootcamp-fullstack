<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Dojo</title>
</head>
<body>

	<h1>${dojo.name}Ninjas</h1>

	<p>
		<a href="/dojos/new">Create Dojo</a> | <a href="/ninjas/new">Create
			Ninja</a>
	</p>

	<table border="1" cellpadding="8">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td>${ninja.firstName}</td>
					<td>${ninja.lastName}</td>
					<td>${ninja.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>