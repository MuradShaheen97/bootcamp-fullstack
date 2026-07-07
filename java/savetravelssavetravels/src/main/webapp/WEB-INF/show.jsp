<!DOCTYPE html>
<html>
<head>
	<title>Expense Details</title>
</head>
<body>

	<h1>Expense Details</h1>

	<a href="/expenses">Go back</a>

	<p>
		<strong>Expense Name:</strong>
		${expense.expenseName}
	</p>

	<p>
		<strong>Expense Description:</strong>
		${expense.description}
	</p>

	<p>
		<strong>Vendor:</strong>
		${expense.vendor}
	</p>

	<p>
		<strong>Amount Spent:</strong>
		$${expense.amount}
	</p>

</body>
</html>