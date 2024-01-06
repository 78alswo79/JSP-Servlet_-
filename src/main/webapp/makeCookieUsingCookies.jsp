<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "util.Cookies" %>
<%
	response.addCookie(Cookies.createCookie("name", "DAVIDLEE"));
	response.addCookie(Cookies.createCookie("id", "madvirus", "/cookiePractice", -1));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Cookie를 사용하여 쿠키사용.
</body>
</html>