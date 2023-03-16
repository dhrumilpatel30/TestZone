<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>
		<%@include file='../components/link.html'%>
	</head>
	<body>
		<%@include file="../components/header.jsp"%>
		<h2>Online Examination System</h2>
		<h3>Welcome ${teacherName} to online examination system</h3>
		<%@include file="../components/footer.html"%>
	</body>
</html>