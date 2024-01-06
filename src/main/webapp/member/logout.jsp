<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "util.Cookies" %>
<%
	response.addCookie(
		Cookies.createCookie("AUTH", "", "/", 0)
	);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	로그아웃 했습니다.
</body>
</html>