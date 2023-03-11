<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Teacher Login</title>
<body>
	<h2>Teacher Login Page</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" action="<%=request.getContextPath()%>/login/teacher">
		Teacher Id: <input name="teacher_id" type="number" /> <br> <br>
		Date of Birth: <input name="dateofbirth" type="number" /> <br>
		***Enter date of Birth in ddmmyyyy format only<br><br>
		<input value="Login now" type="submit"/>
	</form>
</body>
</html>