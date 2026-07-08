<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 40px;
}

.container {
	display: flex;
	gap: 50px;
	align-items: flex-start;
}

.box {
	width: 400px;
	border: 2px solid black;
	padding: 20px;
	background-color: #d7eaff;
}

h1 {
	margin-bottom: 10px;
}

h2 {
	text-align: center;
}

.row {
	display: flex;
	justify-content: space-between;
	margin-bottom: 15px;
}

label {
	width: 150px;
}

input {
	width: 200px;
}

button {
	width: 100%;
	padding: 8px;
	margin-top: 10px;
}

.error {
	color: red;
	font-size: 14px;
	margin-left: 150px;
}
</style>
</head>

<body>

	<h1>Welcome!</h1>
	<p>Join our growing community.</p>

	<div class="container">

		<div class="box">
			<h2>Register</h2>

			<form:form action="/register" method="post" modelAttribute="newUser">

				<div class="row">
					<form:label path="userName">Username:</form:label>
					<form:input path="userName" />
				</div>
				<form:errors path="userName" cssClass="error" />

				<div class="row">
					<form:label path="email">Email:</form:label>
					<form:input path="email" />
				</div>
				<form:errors path="email" cssClass="error" />

				<div class="row">
					<form:label path="password">Password:</form:label>
					<form:password path="password" />
				</div>
				<form:errors path="password" cssClass="error" />

				<div class="row">
					<form:label path="confirm">Confirm PW:</form:label>
					<form:password path="confirm" />
				</div>
				<form:errors path="confirm" cssClass="error" />

				<button type="submit">Submit</button>

			</form:form>
		</div>

		<div class="box">
			<h2>Log In</h2>

			<form:form action="/login" method="post" modelAttribute="newLogin">

				<div class="row">
					<form:label path="email">Email:</form:label>
					<form:input path="email" />
				</div>
				<form:errors path="email" cssClass="error" />

				<div class="row">
					<form:label path="password">Password:</form:label>
					<form:password path="password" />
				</div>
				<form:errors path="password" cssClass="error" />

				<button type="submit">Submit</button>

			</form:form>
		</div>

	</div>

</body>
</html>