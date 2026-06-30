<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Counter Page</title>
</head>
<body>

    <h1>Counter</h1>

    <p>You have visited the home page:</p>

    <h2>${count} times</h2>

    <a href="/">Visit Home Page</a>
    <br><br>

    <a href="/counter2">Increment by 2</a>
    <br><br>

    <form action="/reset" method="post">
        <button type="submit">Reset Counter</button>
    </form>

</body>
</html>