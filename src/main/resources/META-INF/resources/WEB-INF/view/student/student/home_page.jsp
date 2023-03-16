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
	<h2>Quiz's</h2>
	<a href="<%=request.getContextPath()%>/addTeacher">Add</a>
	<br>
	<c:if test="${not empty msg}">
	${msg}
</c:if>
	<c:forEach var="q" items="${students}"> ${q.name} <br> </c:forEach>
	<c:choose>
		<c:when test="${quizs != null}">
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>quiz id</th>
						<th>title</th>
						<th>duration</th>
						<th>Subject</th>
						<th>maximum marks</th>
						<th>submissions</th>
						<th>avg score</th>
						<th>creator teacher name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="q" items="${quizs}">
						<tr>

							<td>quiz_id</td>
							<td>title</td>
							<td>duration</td>
							<td>Subject</td>
							<td>maximum marks</td>
							<td>submissions</td>
							<td>avg score</td>
							<td>creator teacher name</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
	No User found in the DB!
	</c:otherwise>
	</c:choose>

	<%@include file="../components/footer.html"%>
</body>
</html>
