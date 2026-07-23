<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Login and Registration</title></head>
<body>
<h1>Login and Registration</h1>

<h2>Create Account</h2>
<form:form action="/register" method="post" modelAttribute="newUser">
    <!-- REMOVE FIRST NAME: delete firstName field/getter/setter/validation in User.java and this block. -->
    <p><form:label path="firstName">First Name</form:label><br>
    <form:input path="firstName"/><br><form:errors path="firstName"/></p>

    <!-- REMOVE LAST NAME: delete lastName from User.java and this block. -->
    <p><form:label path="lastName">Last Name</form:label><br>
    <form:input path="lastName"/><br><form:errors path="lastName"/></p>

    <p><form:label path="email">Email</form:label><br>
    <form:input path="email" type="email"/><br><form:errors path="email"/></p>
    <p><form:label path="password">Password</form:label><br>
    <form:password path="password"/><br><form:errors path="password"/></p>

    <p><form:label path="confirm">Confirm Password</form:label><br>
    <form:password path="confirm"/><br><form:errors path="confirm"/></p>

    <p><form:checkbox path="acceptedTerms"/> I accept the terms<br>
    <form:errors path="acceptedTerms"/></p>

    <button type="submit">Register</button>
</form:form>

<hr>
<h2>Login</h2>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <p><form:label path="email">Email</form:label><br>
    <form:input path="email" type="email"/><br><form:errors path="email"/></p>

    <p><form:label path="password">Password</form:label><br>
    <form:password path="password"/><br><form:errors path="password"/></p>

    <button type="submit">Login</button>
</form:form>
</body>
</html>
