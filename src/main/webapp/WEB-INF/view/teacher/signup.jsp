<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Teacher Signup</title>
    <%@include file="../components/link.html" %>
</head>
<body>
<%@include file='../components/header.jsp' %>
<div class='w-50 mx-auto my-5'>
    <h2>Teacher Signup Page</h2>
    <form:form action="/teacher/signup" modelAttribute="teacher" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" type="email" cssClass="form-control" id='email' required="true"/>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input path="name" type='text' cssClass="form-control" id='name' required="true"/>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Date of Birth</label>
            <form:input path="date_of_birth" type='date' cssClass="form-control" id='dob' required="true"/>
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <form:select path="gender" id='gender' cssClass="form-control" required="true">
                <form:option value="Male" label="Male"/>
                <form:option value="Female" label="Female"/>
            </form:select>
        </div>
        <div class="mb-3">
            <label for="pass" class="form-label">Password</label>
            <form:input path="password" type='password' cssClass="form-control" id='pass' required="true"/>
        </div>
        <button class='w-100 btn btn-dark' type="submit">Submit</button>
    </form:form>
</div>
<%@include file='../components/footer.html' %>
</body>
</html>