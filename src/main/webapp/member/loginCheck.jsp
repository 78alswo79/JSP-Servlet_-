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
���̵� : "<%=cookies.getValue("AUTH") %>"�� �α��� �� ����
<%
	} else {
%>
�α��� ���� ���� ����.
<%
	}
%>
</body>
</html>