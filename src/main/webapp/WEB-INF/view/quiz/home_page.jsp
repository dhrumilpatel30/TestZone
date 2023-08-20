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
    <a href="/question/addQuestion/${quiz.quiz_id}">
        <button type="button" class="btn btn-dark mt-2 mb-3">Add Question</button>
    </a>
    <c:choose>
        <c:when test="${questions != null}">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th>question_id</th>
                    <th>question</th>
                    <th>option1</th>
                    <th>option2</th>
                    <th>option3</th>
                    <th>option4</th>
                    <th>correct_answer</th>
                    <th>max_marks</th>
                    <th>Update Question</th>
                    <th>Delete Question</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${questions}">
                    <tr>
                        <td>${q.question_id}</td>
                        <td>${q.question}</td>
                        <td>${q.option1}</td>
                        <td>${q.option2}</td>
                        <td>${q.option3}</td>
                        <td>${q.option4}</td>
                        <td>${q.correct_answer}</td>
                        <td>${q.max_marks}</td>
                        <td><a href="<%=request.getContextPath()%>/question/update/${q.question_id}">
                            <button type="button" class="btn btn-dark">Update</button>
                        </a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal">
                                Delete Question
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
                                        <h5>You are deleting Question ${q.question}</h5><br>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">
                                            Cancel Deletion
                                        </button>
                                        <a href="<%=request.getContextPath()%>/question/delete/${q.question_id}">
                                            <button type="button" class="btn btn-dark">Confirm For Deleting Question
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
            <c:if test="${empty questions}"><h3 style="text-align: center;">
                No Questions added</h3></c:if>
        </c:when>
    </c:choose>
</div>

<%@include file="../components/footer.html" %>
</body>
</html>
