<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "util.Cookies" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if (id.equals(password)) {
		// id와 password가 같으면 로그인에 성공한 것으로 판단!
		response.addCookie(
			Cookies.createCookie("AUTH", id, "/", -1)		
		);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	로그인에 성공했습니다.
</body>
</html>
<%
	} else {
	// 로그인 실패 시
%>
<script type="text/javascript">
	alert("로그인에 실패했음!");
	history.go(-1);
</script>
<%
	}
%>
