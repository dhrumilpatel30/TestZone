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
	<c:if test="${not empty error}">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
			${error}
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>
	<c:if test="${result != null}">
        <p>
            Quiz Details:<br>
            Quiz Title: ${result.quiz_id.quiz_title}<br>
            Quiz Duration: ${result.quiz_id.duration} min <br>
            Quiz Obtained Marks: ${result.result}<br>
            Quiz Total Maximum Marks: ${result.quiz_id.total_max_marks}<br>
            Quiz Passing Marks: ${result.quiz_id.passing_marks}<br>
        </p><br>
    </c:if>
	<br>
	<c:choose>
	<c:when test="${scores != null}">
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>question_id</th>
					<th>question</th>
					<th>options</th>
					<th>correct_answer</th>
                    <th>Your Answer</th>
					<th>Marks Obtained</th>
					<th>Total Marks</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${scores}">
					<tr>
						<td>${s.question_id.question_id}</td>
						<td>${s.question_id.question}</td>
						<td>1. ${s.question_id.option1}<br>
                                2.${s.question_id.option2}<br>
                                3.${s.question_id.option3}<br>
                                4.${s.question_id.option4}</td>
						<td>${s.question_id.correct_answer}</td>
						<td>
							<c:if test="${s.choosen_answer eq '-1'}">
								No Answer Selected.
							</c:if>
							<c:if test="${s.choosen_answer eq '-1' == false}">
								${s.choosen_answer}
							</c:if>
						</td>
						<td>${s.score}</td>
						<td>${s.question_id.max_marks}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
</c:choose>
<%@include file="../components/footer.html"%>
</body>
</html>
