<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
Created by IntelliJ IDEA.
User: namnh
Date: 5/24/2023
Time: 8:54 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select-playlist</title>
    <link rel="stylesheet" href="css/bootstrap_css/bootstrap.css">
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="css/bootstrap_js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bbbce8c886.js" crossorigin="anonymous"></script>
</head>
<body class="overflow-hidden">
<h1>Add new employee</h1>
<form method="post">
    <c:if test="${employee != null}">
        <label for="name">Name</label><br>
        <input type="hidden" id="name" name="id" value="<c:out value='${employee.id}' />"/>
        <input type= id="name" name="id" value="<c:out value='${employee.name}'/>"/>
        <label>Email</label>
        <input name="email" id="email" value="<c:out value='${employee.email}'/>" placeholder="enter email">
        <label>Address</label>
        <input name="address" id="address" value="<c:out value='${employee.address}'/>" placeholder="enter address">
        <label>PhoneNumber</label>
        <input name="phonenum" id="phonenum" value="<c:out value='${employee.phonenum}'/>" placeholder="enter phone number">
        <label>Salary</label>
        <input name="salary" id="salaray" value="<c:out value='${employee.salary}'/>" placeholder="enter salary">
        <label>Department</label>
        <select id="cars">
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="vw">VW</option>
            <option value="audi" selected>Audi</option>
        </select>
    </c:if>
    <input type="submit" value="Submit">
</form>


</body>
</html>

