<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>

    <h1>Welcome, <c:out value="${user.firstName}"/>!</h1>
    <a href="/logout">Logout</a>

    <hr>

    <!-- ONE-TO-ONE:
         project == null means this user has not created a project yet. -->
    <c:choose>

        <c:when test="${project == null}">
            <h2>You do not have a project yet.</h2>
            <a href="/projects/new">Create My Project</a>
        </c:when>

        <c:otherwise>
            <h2>My Project</h2>

            <p>
                <strong>Title:</strong>
                <c:out value="${project.title}"/>
            </p>

            <p>
                <strong>Description:</strong>
                <c:out value="${project.description}"/>
            </p>

            <p>
                <strong>Due Date:</strong>
                <fmt:formatDate value="${project.dueDate}" pattern="yyyy-MM-dd"/>
            </p>

            <!-- Direct actions. There is no Join Team button. -->
            <a href="/projects/${project.id}">View</a>
            |
            <a href="/projects/${project.id}/edit">Edit</a>

            <form action="/projects/${project.id}/delete"
                  method="post"
                  style="display:inline;">
                <button type="submit"
                        onclick="return confirm('Delete this project?')">
                    Delete
                </button>
            </form>
        </c:otherwise>

    </c:choose>

</body>
</html>
