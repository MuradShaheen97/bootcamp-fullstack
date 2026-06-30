<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Omikuji Form</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h1>Send an Omikuji!</h1>

    <form action="/omikuji/process" method="post">

        <label>Pick any number from 5 to 25:</label>
        <input type="number" name="number" min="5" max="25">

        <label>Enter the name of any city:</label>
        <input type="text" name="city">

        <label>Enter the name of any real person:</label>
        <input type="text" name="person">

        <label>Enter professional endeavor or hobby:</label>
        <input type="text" name="hobby">

        <label>Enter any type of living thing:</label>
        <input type="text" name="thing">

        <label>Say something nice to someone:</label>
        <textarea name="nice"></textarea>

        <p>Send and show a friend</p>

        <button type="submit">Send</button>
    </form>
</div>

</body>
</html>