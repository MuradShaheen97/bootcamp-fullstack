<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Fruit Store</title>

			<style>
				body {
					font-family: Arial, sans-serif;
					background-color: #f7f7f7;
				}

				.container {
					width: 500px;
					margin: 50px auto;
				}

				h1 {
					color: #ff7f8f;
				}

				.box {
					background-color: #ffb6c1;
					padding: 20px;
				}

				table {
					width: 100%;
					background-color: white;
					border-collapse: collapse;
				}

				th,
				td {
					padding: 15px;
					border-bottom: 1px solid #ddd;
					text-align: left;
				}

				.orange {
					color: orange;
					font-weight: bold;
				}
			</style>
		</head>

		<body>

			<div class="container">
				<h1>Fruit Store</h1>

				<div class="box">
					<table>
						<thead>
							<tr>
								<th>Name</th>
								<th>Price</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="fruit" items="${fruits}">
								<tr>
									<td>
										<c:choose>
											<c:when test="${fruit.name.startsWith('G')}">
												<span class="orange">${fruit.name}</span>
											</c:when>
											<c:otherwise>
												${fruit.name}
											</c:otherwise>
										</c:choose>
									</td>
									<td>${fruit.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</body>

		</html>