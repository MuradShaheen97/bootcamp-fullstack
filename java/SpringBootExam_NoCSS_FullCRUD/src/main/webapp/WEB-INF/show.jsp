<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Blog Details</title></head>
<body>
    <h1><c:out value="${blog.title}"/></h1>
    <p><a href="/dashboard">Back to Dashboard</a></p>
    <p><strong>Author:</strong> <c:out value="${blog.author}"/></p>
    <p><strong>Date:</strong> <c:out value="${blog.eventDate}"/></p>
    <p><strong>Category:</strong> <c:out value="${blog.category}"/></p>
    <p><strong>Content:</strong> <c:out value="${blog.content}"/></p>
    <p><strong>Owner:</strong> <c:out value="${blog.owner.firstName}"/> <c:out value="${blog.owner.lastName}"/></p>
</body>
</html>
