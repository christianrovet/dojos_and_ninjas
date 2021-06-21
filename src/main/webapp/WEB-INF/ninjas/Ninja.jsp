<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
		<a href="/">Home</a>
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Select a Dojo:</form:label>
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.getId()}"><c:out value="${dojo.getName()}"/></form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path ="firstName"/>
		</p>
		<p>
			<form:label path="lastName"> Last Name:</form:label>
			<form:input path="lastName"/>
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:input type="number" path="age"/>
		</p>
		<input type="submit" value="Create"/>
		</form:form>
		<form:errors path="ninja.*"/>
	</div>
</body>
</html>