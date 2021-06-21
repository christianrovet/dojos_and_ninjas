<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
	<a href="/">Home</a>
		<c:if test="${not empty dojo.getNinjas()}">
			<h2 class="text-center">
				<c:out value="${dojo.getName()}" />
				Ninjas
			</h2>
			<a href="/ninjas/new">Create a new Ninja</a>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<c:forEach items="${dojo.ninjas}" var="ninja">
			<tr>
				<td><c:out value="${ninja.firstName}" /></td>
				<td><c:out value="${ninja.lastName}" /></td>
				<td><c:out value="${ninja.age}" /></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>

	<c:if test="${empty dojo.getNinjas()}">

		<h1 class="text-center">No ninjas added yet...</h1>

	</c:if>

	</div>
</body>
</html>