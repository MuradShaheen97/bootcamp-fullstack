<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
</head>
<body>
<h1>${book.title}</h1>

<ul>
    <li><strong>Description:</strong> ${book.descreption}</li>
    <li><strong>Language:</strong> ${book.language}</li>
    <li><strong>Pages:</strong> ${book.pages}</li>
    <li><strong>Created At:</strong>
        <fmt:formatDate value="${book.createdAt}" pattern="yyyy-MM-dd" />
    </li>
</ul>
</body>
</html>