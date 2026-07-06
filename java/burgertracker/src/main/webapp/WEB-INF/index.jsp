<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
</head>
<body>

	<h1>Burger Tracker</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating</th>
				<th>Notes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td>${burger.burgerName}</td>
					<td>${burger.restaurantName}</td>
					<td>${burger.rating}</td>
					<td>${burger.notes}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>Add a Burger</h2>

	<form:form action="/burgers" method="post" modelAttribute="burger">

		<div>
			<form:label path="burgerName">Burger Name:</form:label>
			<form:errors path="burgerName" />
			<form:input path="burgerName" />
		</div>

		<div>
			<form:label path="restaurantName">Restaurant Name:</form:label>
			<form:errors path="restaurantName" />
			<form:input path="restaurantName" />
		</div>

		<div>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating" />
			<form:input type="number" path="rating" />
		</div>

		<div>
			<form:label path="notes">Notes:</form:label>
			<form:errors path="notes" />
			<form:textarea path="notes" />
		</div>

		<input type="submit" value="Submit">

	</form:form>

</body>
</html>