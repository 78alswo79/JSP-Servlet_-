<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import = "util.Cookies" %>
<%
	Cookies cookies = new Cookies(request);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	name 쿠키 = <%= cookies.getValue("name") %> <br>
<% if (cookies.exists("id")) { %>
	id 쿠키 = <%= cookies.getValue("id") %> <br>
<% } %>
</body>
</html>