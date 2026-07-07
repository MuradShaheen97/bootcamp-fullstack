<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Travels</title>
</head>
<body>

	<h1>Save Travels</h1>

	<table border="1">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="expense" items="${expenses}">
			<tr>
				<td>
					<a href="/expenses/${expense.id}">
						${expense.expenseName}
					</a>
				</td>
				<td>${expense.vendor}</td>
				<td>$${expense.amount}</td>
				<td>
					<a href="/expenses/edit/${expense.id}">edit</a>

					<form action="/expenses/${expense.id}" method="post" style="display:inline;">
						<input type="hidden" name="_method" value="delete">
						<button type="submit">delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<h2>Add an expense:</h2>

	<form:form action="/expenses" method="post" modelAttribute="expense">

		<p>
			<form:label path="expenseName">Expense Name:</form:label>
			<form:errors path="expenseName" style="color:red;" />
			<form:input path="expenseName" />
		</p>

		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" style="color:red;" />
			<form:input path="vendor" />
		</p>

		<p>
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount" style="color:red;" />
			<form:input path="amount" type="number" step="0.01" />
		</p>

		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" style="color:red;" />
			<form:textarea path="description" />
		</p>

		<button type="submit">Submit</button>

	</form:form>

</body>
</html>