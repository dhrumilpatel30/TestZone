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
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <c:choose>
        <c:when test="${quizzesPending != null}">
            <h3>Pending Quiz's</h3>
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>duration</th>
                    <th>Subject</th>
                    <th>maximum marks</th>
                    <th>Passing Marks</th>
                    <th>avg score</th>
                    <th>Give Test</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${quizzesPending}">
                    <tr>
                        <td>${q.quiz_id}</td>
                        <td>${q.quiz_title}</td>
                        <td>${q.duration} min</td>
                        <td>${q.subject}</td>
                        <td>${q.total_max_marks}</td>
                        <td>${q.passing_marks}</td>
                        <td>${q.avg_score}</td>
                        <td>
                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal">
                                Start Quiz
                            </button>
                        </td>
                        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="exampleModalLabel">Start Confirmation</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <h5>You are Starting Quiz ${q.quiz_title} Exam</h5><br>
                                        <ul>
                                            <li><h6>Starting quiz means you can not reattempt or complete it later</h6>
                                            </li>
                                            <li><h6>You have to make sure that you have proper network connection</h6>
                                            </li>
                                            <li><h6>It has no negative marking.</h6></li>
                                        </ul>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">
                                            Cancel Start
                                        </button>
                                        <a href="<%=
						request.getContextPath()
						%>/exam/${q.quiz_id}">
                                            <button type="button" class="btn btn-dark">Confirm For Starting Quiz
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty quizzesPending}">
                <div
                        style="text-align: center;"><h4>No Quiz Pending, Enjoy :)</h4></div>
            </c:if>
        </c:when>
    </c:choose>

    <br><br><br>
    <c:choose>
        <c:when test="${quizzesCompleted != null}">
            <h3>Completed Quiz's</h3>
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>duration</th>
                    <th>Subject</th>
                    <th>maximum marks</th>
                    <th>Passing Marks</th>
                    <th>avg score</th>
                    <th>Result</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${quizzesCompleted}">
                    <tr>
                        <td>${q.quiz_id}</td>
                        <td>${q.quiz_title}</td>
                        <td>${q.duration} min</td>
                        <td>${q.subject}</td>
                        <td>${q.total_max_marks}</td>
                        <td>${q.passing_marks}</td>
                        <td>${q.avg_score}</td>
                        <td><a href="<%=
						request.getContextPath()
						%>/exam/showResult/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">View Result</button>
                        </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty quizzesCompleted}">
                <center><h4>No Quiz Completed</h4></center>
            </c:if>
        </c:when>
    </c:choose>
</div>
<%@include file="../components/footer.html" %>
</body>
</html>
