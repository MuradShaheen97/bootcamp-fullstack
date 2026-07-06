<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<h1>the car Factory</h1>
	<form:form action="/addCar" method="post" modelAttribute="car">

		<form:label path="company"> company name</form:label>
		<form:errors path="company" />
		<form:input path="company" />

		<form:label path="color"> car color</form:label>
		<form:errors path="color" />
		<form:input path="color" />

		<form:label path="model"> car model</form:label>
		<form:errors path="model" />
		<form:input path="model" />

		<form:label path="fule"> fuel type</form:label>
		<form:errors path="fule" />
		<form:input path="fule" />

		<form:label path="carDate">car created date</form:label>
		<form:errors path="carDate" />
		<form:input type="Date" path="carDate" />

		<button type="submit">Submit</button>





	</form:form>


</body>
</html>