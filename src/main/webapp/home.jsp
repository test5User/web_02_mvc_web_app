<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String header = "Hello from JSP!!!";
%>
<html>
<head>
    <title>Home page</title>
</head>
<body>
  <h1><%= header %></h1>
  <p>Today <%= new Date()%></p>
</body>
</html>
