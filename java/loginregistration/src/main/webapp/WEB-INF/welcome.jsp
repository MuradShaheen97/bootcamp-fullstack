<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 40px;
}

a {
	color: blue;
}
</style>
</head>

<body>

	<h1>Welcome, ${user.userName}!</h1>

	<p>This is your dashboard. Nothing to see here yet.</p>

	<a href="/logout">Logout</a>

</body>
</html>