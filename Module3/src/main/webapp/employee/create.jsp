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
    <label for="name">Name</label><br>
    <input name="name" id="name" placeholder="enter name"><br>
    <label>Email</label><br>
    <input name="email" id="email" placeholder="enter email"><br>
    <label>Address</label><br>
    <input name="address" id="address" placeholder="enter address"><br>
    <label>PhoneNumber</label><br>
    <input name="phonenum" id="phonenum" placeholder="enter phone number">
    <br>
    <label>Salary</label><br>
    <input name="salary" id="salaray" placeholder="enter salary">
    <br>
    <label>Department</label><br>
    <select id="cars">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="vw">VW</option>
        <option value="audi" selected>Audi</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>

