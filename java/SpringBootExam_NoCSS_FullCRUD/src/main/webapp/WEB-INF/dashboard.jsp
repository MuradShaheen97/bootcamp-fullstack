<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>
		Welcome,
		<c:out value="${currentUser.firstName}" />
		!
	</h1>
	<p>
		<a href="/blogs/new">Create New Blog</a> | <a href="/logout">Logout</a>
	</p>

	<h2>All Blogs</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Date</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="blog" items="${allBlogs}">
				<tr>
					<td><a href="/blogs/${blog.id}"><c:out
								value="${blog.title}" /></a></td>
					<td><c:out value="${blog.author}" /></td>
					<td><c:out value="${blog.eventDate}" /></td>
					<td><c:out value="${blog.owner.firstName}" /> <c:out
							value="${blog.owner.lastName}" /></td>
					<td><c:if test="${blog.owner.id == currentUser.id}">
							<a href="/blogs/${blog.id}/edit">Edit</a>
							<form action="/blogs/${blog.id}/delete" method="post"
								style="display: inline;">
								<button type="submit">Delete</button>
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>My Blogs</h2>
	<ul>
		<c:forEach var="blog" items="${myBlogs}">
			<li><a href="/blogs/${blog.id}"><c:out value="${blog.title}" /></a></li>
		</c:forEach>
	</ul>
</body>
</html>
