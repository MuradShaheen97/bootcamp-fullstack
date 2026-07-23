<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Blog</title>
    <style>.error { color: red; }</style>
</head>
<body>
    <h1>Edit Blog</h1>
    <p><a href="/dashboard">Back to Dashboard</a></p>

    <form:form action="/blogs/${editBlog.id}/update" method="post" modelAttribute="editBlog">
        <p><form:label path="title">Blog Title</form:label><br><form:input path="title"/><br><form:errors path="title" cssClass="error"/></p>
        <p><form:label path="author">Author</form:label><br><form:input path="author"/><br><form:errors path="author" cssClass="error"/></p>
        <p><form:label path="eventDate">Date</form:label><br><form:input path="eventDate" type="date"/><br><form:errors path="eventDate" cssClass="error"/></p>
        <p><form:label path="category">Category</form:label><br><form:input path="category"/><br><form:errors path="category" cssClass="error"/></p>
        <p><form:label path="content">Content</form:label><br><form:textarea path="content"/><br><form:errors path="content" cssClass="error"/></p>
        <button type="submit">Update</button>
    </form:form>
</body>
</html>
