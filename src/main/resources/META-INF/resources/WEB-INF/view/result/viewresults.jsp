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
	<h2>Quiz</h2
		<c:if test="${quiz != null}">
        <p>
            Quiz Details:<br>
            Quiz Title: ${quiz.quiz_title}<br>
            Quiz Duration: ${quiz.duration} min <br>
            Quiz Total Maximum Marks: ${quiz.total_max_marks}<br>
            Quiz Total Avg Marks: ${quiz.avg_score}<br>
            Quiz Total Passing Marks: ${quiz.passing_marks}<br>
        </p><br>
    </c:if>
	<br>
	<c:choose>
	<c:when test="${resultPassed != null}">
		<h4>Passed Students</h4>
		<table class="table">
			<thead>
				<tr>
                    <th>Result Id</th>
                    <th>Student Name</th>
                    <th>Student Id</th>
                    <th>Obtained Marks</th>
                    <th>View Complete Result</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${resultPassed}">
					<tr>
                        <td>${r.result_id}</td>
                        <td>${r.student_id.name}</td>
                        <td>${r.student_id.id}</td>
                        <td>${r.result}</td>
						<td><a href="<%=request.getContextPath()%>/result/studentResult/${r.result_id}"><button type="button" class="btn btn-dark">view Complete Result</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        <c:if test="${empty resultPassed}">No one is Passed Yet!</c:if>
	</c:when>
</c:choose>
	<c:choose>
	<c:when test="${resultFailed != null}">
		<h4>Failed Students</h4>
		<table class="table">
			<thead>
				<tr>
                    <th>Result Id</th>
                    <th>Student Name</th>
                    <th>Student Id</th>
                    <th>Obtained Marks</th>
                    <th>View Complete Result</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${resultFailed}">
					<tr>
                        <td>${r.result_id}</td>
                        <td>${r.student_id.name}</td>
                        <td>${r.student_id.id}</td>
                        <td>${r.result}</td>
						<td><a href="<%=request.getContextPath()%>/result/studentResult/${r.result_id}"><button type="button" class="btn btn-dark">view Complete Result</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        <c:if test="${empty resultFailed}">No one is Failed</c:if>
	</c:when>
</c:choose>

	<%@include file="../components/footer.html"%>
</body>
</html>