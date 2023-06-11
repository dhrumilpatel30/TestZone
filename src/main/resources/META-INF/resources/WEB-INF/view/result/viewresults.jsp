<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <%@include file='../components/link.html' %>
</head>
<body>
<%@include file="../components/header.jsp" %>
<div class="container p-3">
    <h2>Quiz</h2>
    <c:if test="${quiz != null}">
        <div class="card bg-light mb-3" style="max-width: 20rem;">
            <div class="card-header text-white" style="background-color: #212529;">Quiz Details</div>
            <div class="card-body">
                <h3 class="card-title">${quiz.quiz_title}</h3>
                <p class="card-text">
                    Quiz Subject Name: ${quiz.subject}<br>
                    Quiz Duration: ${quiz.duration} min <br>
                    Total Maximum Marks: ${quiz.total_max_marks}<br>
                    Total Passing Marks: ${quiz.passing_marks}<br>
                    Total Avg Marks: ${quiz.avg_score}<br>
                </p>
            </div>
        </div>
    </c:if>
    <br>
    <c:choose>
        <c:when test="${resultPassed != null}">
            <h4>Passed Students</h4>
            <table class="table">
                <thead class="table-dark">
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
                        <td><a href="<%=request.getContextPath()%>/result/studentResult/${r.result_id}">
                            <button type="button" class="btn btn-dark">view Complete Result</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty resultPassed}"><center><h4>No one is Passed Yet!</h4></center></c:if>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${resultFailed != null}">
            <h4>Failed Students</h4>
            <table class="table">
                <thead class="table-dark">
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
                        <td><a href="<%=request.getContextPath()%>/result/studentResult/${r.result_id}">
                            <button type="button" class="btn btn-dark">view Complete Result</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty resultFailed}">
                <center><h4>No one is Failed</h4></center>
            </c:if>
        </c:when>
    </c:choose>
</div>
<%@include file="../components/footer.html" %>
</body>
</html>
