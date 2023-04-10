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
<script>
    window.

</script>
<%@include file="../components/header.jsp" %>
<div class="container p-3">
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
        <h2>Result</h2>
        <div class="row">
            <div class="col-4">
                <div class="card bg-light m-3" style="max-width: 25rem;">
                    <div class="card-header text-white" style="background-color: #212529;">Quiz Details</div>
                    <div class="card-body">
                        <h3 class="card-title">${result.quiz_id.quiz_title}</h3>
                        <p class="card-text">
                            Quiz Id: ${result.quiz_id.quiz_id}<br>
                            Quiz Duration: ${result.quiz_id.duration} min <br>
                            Quiz Subject Name: ${result.quiz_id.subject}<br>
                            Quiz Teacher Name: ${result.quiz_id.teacher_id.name}<br>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card bg-light m-3" style="max-width: 25rem;">
                    <div class="card-header text-white" style="background-color: #212529;">Result Details</div>
                    <div class="card-body">
                        <c:if test="${result.result < result.quiz_id.passing_marks}">
                            <h3 class="card-title text-danger">Not Pass</h3>
                        </c:if>
                        <c:if test="${result.result >= result.quiz_id.passing_marks}">
                            <h3 class="card-title text-success">Pass</h3>
                        </c:if>
                        <p class="card-text">
                            Total Obtained Marks: ${result.result}<br>
                            Total Passing Marks: ${result.quiz_id.passing_marks}<br>
                            Total Avg Marks: ${result.quiz_id.avg_score}<br>
                            Total Maximum Marks: ${result.quiz_id.total_max_marks}<br>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card bg-light m-3" style="max-width: 25rem;">
                    <div class="card-header text-white" style="background-color: #212529;">Student Details</div>
                    <div class="card-body">
                        <h3 class="card-title">${result.student_id.name}</h3>
                        <p class="card-text">
                            Student Id: ${result.student_id.id} <br>
                            Student Email: ${result.student_id.email}<br>
                            Student Date Of Birth: ${result.student_id.date_of_birth}<br>
                            Student Gender: ${result.student_id.gender}<br>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <br>
    <c:choose>
        <c:when test="${scores != null}">
            <table class="table">
                <thead class="table-dark">
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
                        <td>${s.question_id.option1}<br>
                                ${s.question_id.option2}<br>
                                ${s.question_id.option3}<br>
                                ${s.question_id.option4}</td>
                        <td>${s.question_id.correct_answer}</td>
                        <td>
                            <c:if test="${s.choosen_answer eq '0'}">
                                Not Attempted.
                            </c:if>
                            <c:if test="${s.choosen_answer eq '0' == false}">
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
</div>
<%@include file="../components/footer.html" %>
</body>
</html>
