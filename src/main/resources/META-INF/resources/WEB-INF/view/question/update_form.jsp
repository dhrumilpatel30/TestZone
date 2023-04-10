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
<div class="container">
    <div class='w-60 mx-auto my-5'>
        <h2>Edit/Add Question</h2>
        <form:form action="http://localhost:8080/question/update" modelAttribute="question" method="post">
            <form:input path="question_id" value="${question.question_id}" type="hidden"/>
            <div class="mb-3">
                <label for="question" class="form-label">Full Question</label>
                <form:input path="question" type="text" cssClass="form-control" id='question' required="true"/>
            </div>
            <div class="mb-3">
                <label for="option1" class="form-label">option1</label>
                <form:input path="option1" type="text" cssClass="form-control" id='option1' required="true"/>
            </div>
            <div class="mb-3">
                <label for="option2" class="form-label">option2</label>
                <form:input path="option2" type="text" cssClass="form-control" id='option2' required="true"/>
            </div>
            <div class="mb-3">
                <label for="option3" class="form-label">option3</label>
                <form:input path="option3" type="text" cssClass="form-control" id='option3' required="true"/>
            </div>
            <div class="mb-3">
                <label for="option4" class="form-label">option4</label>
                <form:input path="option4" type="text" cssClass="form-control" id='option4' required="true"/>
            </div>
            <div class="mb-3">
                <label for="correct_answer" class="form-label">Correct Option</label>
                <form:select path="correct_answer" id='correct_answer' cssClass="form-control" required="true">
                    <form:option value="1" label="option 1"/>
                    <form:option value="2" label="option 2"/>
                    <form:option value="3" label="option 3"/>
                    <form:option value="4" label="option 4"/>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="max_marks" class="form-label">Max Marks</label>
                <form:input path="max_marks" type="number" cssClass="form-control" id='max_marks'
                            required="true"/>
            </div>
            <button class='w-100 btn btn-dark' type="submit">Submit</button>
        </form:form>
    </div>
</div>
<%@include file='../components/footer.html' %>
</body>
</html>