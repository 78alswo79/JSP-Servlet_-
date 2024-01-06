<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
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
<%
	if (cookies.exists("AUTH")) {
%>
아이디 : "<%=cookies.getValue("AUTH") %>"로 로그인 한 상태
<%
	} else {
%>
로그인 하지 않은 상태.
<%
	}
%>
</body>
</html>