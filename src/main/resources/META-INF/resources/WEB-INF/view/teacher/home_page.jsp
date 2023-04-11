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
    <h2>Your Quizzes</h2>
    <a href="<%=request.getContextPath()%>/quiz/addQuiz">
        <button type="button" class="btn btn-dark mt-2 mb-3">Add a new Quiz</button>
    </a>
    <c:choose>
        <c:when test="${quizzesYours != null}">
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
                    <th>Edit Questions</th>
                    <th>Edit Quiz</th>
                    <th>Delete Quiz</th>
                    <th>Publish Quiz</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${quizzesYours}">
                    <tr>
                        <td>${q.quiz_id}</td>
                        <td>${q.quiz_title}</td>
                        <td>${q.duration} min</td>
                        <td>${q.subject}</td>
                        <td>${q.total_max_marks}</td>
                        <td>${q.passing_marks}</td>
                        <td>${q.avg_score}</td>
                        <td><a href="<%=request.getContextPath()%>/quiz/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">Edit Questions</button>
                        </a></td>
                        <td><a href="<%=request.getContextPath()%>/quiz/update/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">Update Quiz</button>
                        </a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal">
                                Delete Quiz
                            </button>
                        </td>
                        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="exampleModalLabel">Delete Confirmation</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <h5>You are deleting Quiz ${q.quiz_title}</h5><br>
                                        <h6>Deleting quiz will delete all it's results and scores.</h6>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">
                                            Cancel Deletion
                                        </button>
                                        <a href="<%=request.getContextPath()%>/quiz/delete/${q.quiz_id}">
                                            <button type="button" class="btn btn-dark">Confirm For Deleting Quiz
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <td><a href="<%=request.getContextPath()%>quiz/publish/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">Publish</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty quizzesYours}">
                <center><h4>No Quiz Created</h4></center>
            </c:if>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${quizzesPublished != null}">
            <h2>Your Published Quizzes</h2>
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
                    <th>View Quiz Results</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${quizzesPublished}">
                    <tr>
                        <td>${q.quiz_id}</td>
                        <td>${q.quiz_title}</td>
                        <td>${q.duration} min</td>
                        <td>${q.subject}</td>
                        <td>${q.total_max_marks}</td>
                        <td>${q.passing_marks}</td>
                        <td>${q.avg_score}</td>
                        <td><a href="<%=request.getContextPath()%>/result/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">Quiz Results</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty quizzesPublished}">
                <center><h4>No Quiz Published By You</h4></center>
            </c:if>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${quizzesOthers != null}">
            <h2>Other Teachers Quizzes</h2>
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
                    <th>Created By</th>
                    <th>View Quiz Results</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${quizzesOthers}">
                    <tr>
                        <td>${q.quiz_id}</td>
                        <td>${q.quiz_title}</td>
                        <td>${q.duration} min</td>
                        <td>${q.subject}</td>
                        <td>${q.total_max_marks}</td>
                        <td>${q.passing_marks}</td>
                        <td>${q.avg_score}</td>
                        <td>${q.teacher_id.name}</td>
                        <td><a href="<%=request.getContextPath()%>/result/${q.quiz_id}">
                            <button type="button" class="btn btn-dark">Quiz Results</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty quizzesOthers}">
                <center><h4>No Quiz Created By Others</h4></center>
            </c:if>
        </c:when>
    </c:choose>
</div>

<%@include file="../components/footer.html" %>
</body>
</html>