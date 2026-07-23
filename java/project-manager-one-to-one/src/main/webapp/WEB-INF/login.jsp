<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login and Registration</title>
</head>
<body>

    <h1>Project Manager</h1>

    <hr>

    <h2>Register</h2>

    <!-- modelAttribute must match model.addAttribute("newUser", new User()). -->
    <form:form action="/register" method="post" modelAttribute="newUser">

        <div>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
            <form:errors path="firstName"/>
        </div>

        <div>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </div>

        <div>
            <form:label path="email">Email:</form:label>
            <form:input path="email" type="email"/>
            <form:errors path="email"/>
        </div>

        <div>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password"/>
        </div>

        <div>
            <form:label path="confirm">Confirm Password:</form:label>
            <form:password path="confirm"/>
            <form:errors path="confirm"/>
        </div>

        <button type="submit">Register</button>
    </form:form>

    <hr>

    <h2>Login</h2>

    <form:form action="/login" method="post" modelAttribute="newLogin">

        <div>
            <form:label path="email">Email:</form:label>
            <form:input path="email" type="email"/>
            <form:errors path="email"/>
        </div>

        <div>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password"/>
        </div>

        <button type="submit">Login</button>
    </form:form>

</body>
</html>
