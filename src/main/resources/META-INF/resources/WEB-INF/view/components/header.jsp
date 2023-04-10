<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>header</title>
</head>
<body>

<nav class="navbar navbar-dark sticky-top navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Online Examination System</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <c:if test="${empty role}">
                    <li class="nav-item">
                        <a class="nav-link" href="/student/login">Student Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/teacher/login">Teacher Login</a>
                    </li>
                </c:if>
                <c:if test="${not empty role}">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </c:if>


            </ul>

        </div>
    </div>
</nav>
</body>
</html>