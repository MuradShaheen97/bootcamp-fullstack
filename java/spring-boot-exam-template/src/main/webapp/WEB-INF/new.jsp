<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Item</title>
</head>
<body>

<h1>Create Item</h1>

<form:form action="/items" method="post" modelAttribute="item">

    <p>
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>

    <p>
        <form:label path="description">Description:</form:label>
        <form:textarea path="description"/>
        <form:errors path="description"/>
    </p>

    <p>
        <form:label path="value">Value:</form:label>
        <form:input path="value" type="number" step="0.01"/>
        <form:errors path="value"/>
    </p>

    <button type="submit">Create</button>
</form:form>

<a href="/dashboard">Cancel</a>

</body>
</html>
