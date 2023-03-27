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
	<c:if test="${not empty success}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
			${success}
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>
	<h2>Quiz</h2>
	<br>
	<a href="/question/addQuestion/${quiz.quiz_id}">Add Question</a>
	<c:choose>
	<c:when test="${questions != null}">
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>question_id</th>
					<th>quiz_id</th>
					<th>question</th>
					<th>option1</th>
					<th>option2</th>
					<th>option3</th>
					<th>option4</th>
					<th>correct_answer</th>
					<th>max_marks</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${questions}">
					<tr>
						<td>${q.question_id}</td>
						<td>${q.quiz_id.quiz_title}</td>
						<td>${q.question}</td>
						<td>${q.option1}</td>
						<td>${q.option2}</td>
						<td>${q.option3}</td>
						<td>${q.option4}</td>
						<td>${q.correct_answer}</td>
						<td>${q.max_marks}</td>
						<td><a href="<%=request.getContextPath()%>/question/update/${q.question_id}">Update</a>
							<a href="<%=request.getContextPath()%>/question/delete/${q.question_id}"
							   onclick="return confirm('You are Deleting ${q.question} Confirm?')">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	No Questions added!<br>
	</c:otherwise>
</c:choose>


	<%@include file="../components/footer.html"%>
</body>
</html>