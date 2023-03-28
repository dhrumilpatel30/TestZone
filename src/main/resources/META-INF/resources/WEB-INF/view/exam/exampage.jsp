<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<h2>Quiz</h2>
	<br>
    <c:if test="${quiz != null}">
        <p>
            Quiz Details:<br>
            Quiz Title: ${quiz.quiz_title}<br>
            Quiz Duration: ${quiz.duration} min <br>
            Quiz Total Maximum Marks: ${quiz.total_max_marks}<br>
            Quiz Total Passing Marks: ${quiz.passing_marks}<br>
        </p><br>
    </c:if>
	<c:choose>
	<c:when test="${scores != null}">
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>question_id</th>
					<th>question</th>
					<th>options</th>
					<th>max_marks</th>
				</tr>
			</thead>
			<tbody>
			<form:form action="/exam/calculateResult" modelAttribute="scores" >
				<c:forEach var = "i" begin = "0" end = "${scores.length-1}" varStatus="j">
					<tr><td>${scores.scores[j.index].question_id.question_id}</td>
						<td>${scores.scores[j.index].question_id.question}</td>

						<form:input path="scores[${i}].score_id" value="${scores.scores[j.index].score_id}" type="hidden" />
<%--						<form:input path="scores[${i}].quiz_id" value="${scores.scores[j.index - 1].quiz_id}" type="hidden" />--%>
<%--						<form:input path="scores[${i}].student_id" value="${scores.scores[j.index - 1].student_id}" type="hidden" />--%>
						<td>
<%--							<form:input path=""--%>
		<form:radiobutton path="scores[${i}].score" value="1" />${scores.scores[j.index].question_id.option1}<br>
		<form:radiobutton path="scores[${i}].score" value="2" />${scores.scores[j.index].question_id.option2}<br>
		<form:radiobutton path="scores[${i}].score" value="3" />${scores.scores[j.index].question_id.option3}<br>
		<form:radiobutton path="scores[${i}].score" value="4" />${scores.scores[j.index].question_id.option4}
						<td>${scores.scores[j.index].question_id.max_marks}</td>
					</tr>
				</c:forEach>
				<div style="text-align: center;"><input type="submit" value="Submit Answers"/></div>
			</form:form>
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
