<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <c:choose>
        <c:when test="${scores != null}">
            <h4>Questions</h4>
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col" class="col-1">question_id</th>
                    <th scope="col" class="col-8">question</th>
                    <th scope="col" class="col-1">max_marks</th>
                </tr>
                </thead>
                <tbody>
                <form:form action="/exam/calculateResult" modelAttribute="scores">
                    <c:forEach var="i" begin="0" end="${scores.length-1}" varStatus="j">
                        <tr class="table-light">
                            <th scope="row" class="align-middle">${scores.scores[j.index].question_id.question_id}</th>
                            <td><h3 class="p-4">${scores.scores[j.index].question_id.question}</h3>

                                <form:input path="scores[${i}].score_id" value="${scores.scores[j.index].score_id}"
                                            type="hidden"/>
                                    <%--						<form:input path="scores[${i}].quiz_id" value="${scores.scores[j.index - 1].quiz_id}" type="hidden" />--%>
                                    <%--						<form:input path="scores[${i}].student_id" value="${scores.scores[j.index - 1].student_id}" type="hidden" />--%
                                    <%--							<form:input path=""--%>
                                <form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="1"
                                                  id="${i}+1"/><label
                                        class="col-2 m-2 btn btn-outline-dark"
                                        for="${i}+1">${scores.scores[j.index].question_id.option1}</label>
                                <form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="2"
                                                  id="${i}+2"/><label
                                        class="col-2 m-2 btn btn-outline-dark"
                                        for="${i}+2">${scores.scores[j.index].question_id.option2}</label>
                                <form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="3"
                                                  id="${i}+3"/><label
                                        class="col-2 m-2 btn btn-outline-dark"
                                        for="${i}+3">${scores.scores[j.index].question_id.option3}</label>
                                <form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="4"
                                                  id="${i}+4"/><label
                                        class="col-2 m-2 btn btn-outline-dark"
                                        for="${i}+4">${scores.scores[j.index].question_id.option4}</label>
                                <form:radiobutton class="btn-check" path="scores[${i}].choosen_answer" value="0"
                                                  id="${i}+5"/><label
                                        class="col-2 m-2 btn btn-outline-dark" for="${i}+5">Leave Question</label></td>
                            <td class="align-middle">${scores.scores[j.index].question_id.max_marks}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td style="pointer-events: none;text-align: center;"><br>
                            <button type="submit" class="w-50 btn btn-dark" style="pointer-events:fill "
                                    id="submitButton">Submit Answers
                            </button>
                        </td>
                        <td></td>
                    </tr>
                </form:form>
                </tbody>
            </table>
            <c:if test="${empty scores}">No Questions added</c:if>
        </c:when>
    </c:choose>
</div>


<%@include file="../components/footer.html" %>
</body>
</html>