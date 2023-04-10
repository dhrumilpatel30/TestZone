<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quiz Edit</title>

    <%@include file="../components/link.html" %>
</head>
<body>
<%@include file='../components/header.jsp' %>

<c:if test="${not empty success}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${success}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<div class='w-50 mx-auto my-5'>
    <h2>Quiz Update/Add Form</h2>
    <form:form action="http://localhost:8080/quiz/update" modelAttribute="quiz" method="post">
        <form:input path="quiz_id" value="${quiz.quiz_id}" type="hidden"/>
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <form:input path="quiz_title" type="text" cssClass="form-control" id='title' required="true"/>
        </div>
        <div class="mb-3">
            <label for="duration" class="form-label">Duration(in min)</label>
            <form:input path="duration" type="number" cssClass="form-control" id='duration' required="true"/>
        </div>
        <div class="mb-3">
            <label for="subject" class="form-label">Subject</label>
            <form:input path="subject" type="text" cssClass="form-control" id='subject' required="true"/>
        </div>
        <div class="mb-3">
            <label for="passing_marks" class="form-label">Passing Marks</label>
            <form:input path="passing_marks" type="text" cssClass="form-control" id='passing_marks' required="true"/>
        </div>
        <%--			<div class="mb-3">--%>
        <%--				<label for="total_max_marks" class="form-label">Max Marks</label>--%>
        <form:input path="total_max_marks" type="hidden" value="${quiz.total_max_marks}" id='total_max_marks'/>
        <%--			</div>--%>
        <button class='w-100 btn btn-dark' type="submit">Submit</button>
    </form:form>
</div>
<%@include file='../components/footer.html' %>
</body>
</html>