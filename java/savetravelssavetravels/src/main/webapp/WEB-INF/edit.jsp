<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit Expense</title>
</head>
<body>

	<h1>Edit Expense</h1>

	<a href="/expenses">Go back</a>

	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">

		<input type="hidden" name="_method" value="put">

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