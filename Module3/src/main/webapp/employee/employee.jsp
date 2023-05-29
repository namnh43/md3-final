<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="css/bootstrap_css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
  <script src="css/bootstrap_js/bootstrap.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://kit.fontawesome.com/bbbce8c886.js" crossorigin="anonymous"></script>
</head>
<body>
<br/>
<form action="/home">
  <input name="search" id="search">
  <button type="button" class="btn btn-primary">Search</button></a>
</form>
<table class="table table-striped table-hover">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Name</th>
    <th scope="col">Email</th>
    <th scope="col">Address</th>
    <th scope="col">PhoneNumber</th>
    <th scope="col">Salary</th>
    <th scope="col">Department</th>
    <th scope="col">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employee" items="${list}">
    <tr>
      <td><c:out value="${employee.id}"/></td>
      <td><c:out value="${employee.name}"/></td>
      <td><c:out value="${employee.email}"/></td>
      <td><c:out value="${employee.address}"/></td>
      <td><c:out value="${employee.getPhoneNum()}"/></td>
      <td><c:out value="${employee.salary}"/></td>
      <td><c:out value="${employee.department}"/></td>
      <td>
        <a href="/home?action=edit&id=${employee.id}"><button type="button" class="btn btn-primary">Edit</button></a>
      </td>
      <td>
        <a class="delete_btn" href="/home?action=delete&id=${employee.id}"><button type="button" class="btn btn-primary">Delete</button></a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a class="delete_btn" href="/home?action=create"><button type="button" class="btn btn-primary">Create</button></a>
</body>
</html>