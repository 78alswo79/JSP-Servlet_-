<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "util.Cookies" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if (id.equals(password)) {
		// id�� password�� ������ �α��ο� ������ ������ �Ǵ�!
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
	�α��ο� �����߽��ϴ�.
</body>
</html>
<%
	} else {
	// �α��� ���� ��
%>
<script type="text/javascript">
	alert("�α��ο� ��������!");
	history.go(-1);
</script>
<%
	}
%>
