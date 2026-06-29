<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Date</title>
			<link rel="stylesheet" href="/css/style.css">
		</head>

		<body onload="showDateAlert()">

			<div class="container">
				<h1>
					<fmt:formatDate value="${currentDate}" pattern="EEEE, MMMM dd, yyyy" />
				</h1>

				<a href="/">Back to Dashboard</a>
			</div>

			<script src="/js/script.js"></script>
		</body>

		</html>