<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Project</title>
</head>
<body>

    <h1>Edit Project</h1>

    <form:form action="/projects/${project.id}/update"
               method="post"
               modelAttribute="project">

        <div>
            <form:label path="title">Title:</form:label>
            <form:input path="title"/>
            <form:errors path="title"/>
        </div>

        <div>
            <form:label path="description">Description:</form:label>
            <form:textarea path="description"/>
            <form:errors path="description"/>
        </div>

        <div>
            <form:label path="dueDate">Due Date:</form:label>
            <form:input path="dueDate" type="date"/>
            <form:errors path="dueDate"/>
        </div>

        <button type="submit">Update</button>
    </form:form>

    <a href="/dashboard">Cancel</a>

</body>
</html>
