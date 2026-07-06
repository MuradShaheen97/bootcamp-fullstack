<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>

	<h1>New Ninja</h1>

	<p>
		<a href="/dojos/new">Create Dojo</a>
	</p>

	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">

		<div>
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}">
                        ${dojo.name}
                    </form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo" style="color:red;" />
		</div>

		<br>

		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" style="color:red;" />
		</div>

		<br>

		<div>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" style="color:red;" />
		</div>

		<br>

		<div>
			<form:label path="age">Age:</form:label>
			<form:input path="age" type="number" />
			<form:errors path="age" style="color:red;" />
		</div>

		<br>

		<button type="submit">Create</button>

	</form:form>

</body>
</html>