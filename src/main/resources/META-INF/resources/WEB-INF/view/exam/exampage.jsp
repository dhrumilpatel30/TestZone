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
    <c:if test="${quiz != null}">
        <p>
		<h4>Quiz Details</h4>
            Quiz Title: ${quiz.quiz_title}<br>
            Quiz Duration: ${quiz.duration} min <br>
            Quiz Total Maximum Marks: ${quiz.total_max_marks}<br>
            Quiz Total Passing Marks: ${quiz.passing_marks}<br>
        </p><br>
    </c:if>
	<c:choose>
	<c:when test="${scores != null}">
		<h4>Questions</h4>
		<table class="table">
			<thead>
				<tr>
					<th class="col-1">question_id</th>
					<th class="col-10">question</th>
					<th class="col-1">max_marks</th>
				</tr>
			</thead>
			<tbody>
			<form:form action="/exam/calculateResult" modelAttribute="scores" >
				<c:forEach var = "i" begin = "0" end = "${scores.length-1}" varStatus="j">
					<tr><td>${scores.scores[j.index].question_id.question_id}</td>
						<td><h3>${scores.scores[j.index].question_id.question}</h3>

						<form:input path="scores[${i}].score_id" value="${scores.scores[j.index].score_id}" type="hidden" />
<%--						<form:input path="scores[${i}].quiz_id" value="${scores.scores[j.index - 1].quiz_id}" type="hidden" />--%>
<%--						<form:input path="scores[${i}].student_id" value="${scores.scores[j.index - 1].student_id}" type="hidden" />--%
<%--							<form:input path=""--%>
						<form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="1" id="${i}+1"/><label class="col-2 m-2 btn btn-outline-dark" for="${i}+1">${scores.scores[j.index].question_id.option1}</label>
						<form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="2" id="${i}+2"/><label class="col-2 m-2 btn btn-outline-dark" for="${i}+2">${scores.scores[j.index].question_id.option2}</label>
						<form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="3" id="${i}+3"/><label class="col-2 m-2 btn btn-outline-dark" for="${i}+3">${scores.scores[j.index].question_id.option3}</label>
						<form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="4" id="${i}+4"/><label class="col-2 m-2 btn btn-outline-dark" for="${i}+4">${scores.scores[j.index].question_id.option4}</label>
							<form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="0" id="${i}+5"/><label class="col-2 m-2 btn btn-outline-dark" for="${i}+5">Leave Question</label></td>
						<td>${scores.scores[j.index].question_id.max_marks}</td>
					</tr>
				</c:forEach><br>
				<tr><td></td><td style="text-align: center;"><br>
			<button type="submit" class="w-50 btn btn-dark"
							   onclick="return confirm('Submit Exam Now, Confirm?')">Submit Answers</button></div>
				</td></tr>
			</form:form>
			</tbody>
		</table>
        <c:if test="${empty scores}">No Questions added</c:if>
	</c:when>
</c:choose>


	<%@include file="../components/footer.html"%>
</body>
</html>
