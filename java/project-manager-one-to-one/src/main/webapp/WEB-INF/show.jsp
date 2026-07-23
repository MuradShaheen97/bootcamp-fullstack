<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details</title>
</head>
<body>

    <h1><c:out value="${project.title}"/></h1>

    <p>
        <strong>Description:</strong>
        <c:out value="${project.description}"/>
    </p>

    <p>
        <strong>Due Date:</strong>
        <fmt:formatDate value="${project.dueDate}" pattern="yyyy-MM-dd"/>
    </p>

    <p>
        <strong>Owner:</strong>
        <c:out value="${project.owner.firstName}"/>
        <c:out value="${project.owner.lastName}"/>
    </p>

    <a href="/projects/${project.id}/edit">Edit</a>
    |
    <a href="/dashboard">Dashboard</a>

</body>
</html>
