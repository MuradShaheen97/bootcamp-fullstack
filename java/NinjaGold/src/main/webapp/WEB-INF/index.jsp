<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div class="container">

		<h1>Ninja Gold Game</h1>

		<h2>
			Your Gold: <span><%=session.getAttribute("gold")%></span>
		</h2>

		<div class="places">

			<form action="/process" method="post" class="card">
				<h3>Farm</h3>
				<p>Earns 10 - 20 gold</p>
				<input type="hidden" name="place" value="farm">
				<button>Find Gold</button>
			</form>

			<form action="/process" method="post" class="card">
				<h3>Cave</h3>
				<p>Earns 5 - 10 gold</p>
				<input type="hidden" name="place" value="cave">
				<button>Find Gold</button>
			</form>

			<form action="/process" method="post" class="card">
				<h3>House</h3>
				<p>Earns 2 - 5 gold</p>
				<input type="hidden" name="place" value="house">
				<button>Find Gold</button>
			</form>

			<form action="/process" method="post" class="card">
				<h3>Quest</h3>
				<p>Earns or loses 0 - 50 gold</p>
				<input type="hidden" name="place" value="quest">
				<button>Find Gold</button>
			</form>

			<form action="/process" method="post" class="card">
				<h3>Spa</h3>
				<p>Loses 5 - 20 gold</p>
				<input type="hidden" name="place" value="spa">
				<button>Relax</button>
			</form>

		</div>

		<form action="/process" method="post">
			<input type="hidden" name="place" value="reset">
			<button class="reset">Reset Game</button>
		</form>

		<h3>Activities:</h3>

		<div class="activities">
			<%
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");

			if (activities != null) {
				for (String activity : activities) {
			%>
			<p><%=activity%></p>
			<%
			}
			}
			%>
		</div>

	</div>

</body>
</html>