<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>

<h1>Welcome, <c:out value="${user.firstName}"/></h1>

<a href="/items/new">Create New Item</a>
|
<a href="/logout">Logout</a>

<hr>

<table border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Value</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.value}"/></td>
                <td><c:out value="${item.owner.firstName}"/></td>

                <td>
                    <a href="/items/${item.id}">View</a>

                    <c:if test="${item.owner.id == user.id}">
                        |
                        <a href="/items/${item.id}/edit">Edit</a>

                        <form action="/items/${item.id}/delete"
                              method="post"
                              style="display:inline;">
                            <button type="submit">Delete</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
