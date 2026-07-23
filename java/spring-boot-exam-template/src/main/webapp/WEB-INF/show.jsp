<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item Details</title>
</head>
<body>

<h1><c:out value="${item.name}"/></h1>

<p>
    <strong>Description:</strong>
    <c:out value="${item.description}"/>
</p>

<p>
    <strong>Value:</strong>
    <c:out value="${item.value}"/>
</p>

<p>
    <strong>Owner:</strong>
    <c:out value="${item.owner.firstName}"/>
    <c:out value="${item.owner.lastName}"/>
</p>

<a href="/dashboard">Dashboard</a>

</body>
</html>
