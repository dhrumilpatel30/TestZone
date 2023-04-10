<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Teacher Login</title>
    <%@include file='../components/link.html' %>
</head>
<body>
<%@include file='../components/header.jsp' %>
<div class=' my-5 w-50 mx-auto'>

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
    <h2>Teacher Login Page</h2>
    <form method="POST" action="<%=request.getContextPath()%>/teacher/login">
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name='email'>

        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name='password' class="form-control" id="password">
        </div>
        <div>
            <a href='/teacher/signup'>Or Signup</a>
        </div>
        <button type="submit" class="w-100 btn btn-dark">Submit</button>
    </form>
</div>


<%@include file='../components/footer.html' %>
</body>
</html>