<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <h2>User Info</h2>
    <c:choose>
        <c:when test="${not empty user}">
            <p>id ${user.id}</p>
            <p>name ${user.fio}</p>
            <p>email ${user.email}</p>
        </c:when>
        <c:otherwise>
            <p> ${message} </p>
        </c:otherwise>
    </c:choose>
</body>
</html>
