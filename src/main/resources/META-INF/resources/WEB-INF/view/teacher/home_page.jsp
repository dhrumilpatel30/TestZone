<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Online Examination System</h2>
<h3>Welcome ${teacherName} to online examination system</h3>
<h2>Quiz's</h2>
<c:if test="${not empty msg}">
	${msg}
</c:if>
<c:choose>
	<c:when test="${quizzes != null}">
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>id</th>
					<th>title</th>
					<th>duration</th>
					<th>Subject</th>
					<th>maximum marks</th>
					<th>avg score</th>
					<th>Edit Quiz</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${quizzes}">
					<tr>
						<td>${q.quiz_id}</td>
						<td>${q.quiz_title}</td>
						<td>${q.duration} min</td>
						<td>${q.subject}</td>
						<td>${q.total_max_marks}</td>
						<td>${q.avg_score}</td>
						<td>
							<form method="post" action="<%=request.getContextPath()%>/quiz/update/${q.quiz_id}" >
								<input type="hidden" name="teacher" value="${teacherId}">
								<input type="submit" value="Edit">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	No Quiz found,
		Enjoy :)
	</c:otherwise>
</c:choose>

</body>
</html>