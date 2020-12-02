<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Session 로그인 Main 페이지 입니다.</h2>
	
	<a href="<%= request.getContextPath() %>/sessionLoginServlet.do">
		LOGIN하기
	</a>
<%-- 	<a href="<%= request.getContextPath() %>/03/sessionLogin.jsp">
		LOGIN하기
	</a> --%>

</body>
</html>