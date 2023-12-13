<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<%--Объявить переменную--%>
    <c:set var="number" value="26"/>
<%--Получить значение--%>
    <h2>Number value = ${number} </h2>
    <h2>Number value + 15 = ${number + 15}</h2>
<%--Удалить переменную--%>
    <c:remove var="number"/>
    <h2>Number value = ${number} </h2>
<%--Оператор выбора--%>
    <c:if test="${empty number}">
        <h2>Number not exist</h2>
    </c:if>

    <c:set var="newVar" value="30"/>
    <c:choose>
        <c:when test="${newVar < 5}">
            <h2>Less than 5</h2>
        </c:when>
        <c:when test="${newVar == 5}">
            <h2>Equals 5</h2>
        </c:when>
        <c:otherwise>
            <h2>More than 5</h2>
        </c:otherwise>
    </c:choose>
<%--Оператор url--%>
    <c:url var="link" value="http://google.com" />
    <h2>This <a href="${link}" target="_blank"> link </a> follow to Google</h2>

    <c:url var="link1" value="http://google.com/search">
        <c:param name="q" value="Телевизор"/>
    </c:url>
    <h2>This <a href="${link1}" target="_blank"> link </a> will find "Телевизор"</h2>
<%--Цикл--%>
    <h2>Cookies</h2>
    <ul>
        <c:forEach var="cook" items="${cookie}">
            <li>
                <p><c:out value="${cook.value.name}"/></p>
                <p><c:out value="${cook.value.value}"/></p>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
