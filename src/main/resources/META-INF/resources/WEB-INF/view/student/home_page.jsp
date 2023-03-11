<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Online Examination System</h2>
<h3>Welcome ${studentName} to online examination system</h3>
<h2>Quiz's</h2>
<a href="<%=request.getContextPath()%>/addTeacher">Add</a>
<c:if test="${not empty msg}">
	${msg}
</c:if>
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
				<c:forEach var="t" items="${teachers}">
					<tr>
						<td>${t.id}</td>
						<td>${t.name}</td>
						<td>${t.expertise}</td>
						<td><a
							href="<%=request.getContextPath()%>/teacher/${t.id}">Details</a>
							&nbsp;<a
							href="<%=request.getContextPath()%>/update/teacher/${t.id}">Update</a>
							&nbsp; <a
							href="<%=request.getContextPath()%>/delete/teacher/${t.id}"
							onclick="return confirm('Do you really want to delete?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	No User found in the DB!
	</c:otherwise>
</c:choose>

</body>
</html>