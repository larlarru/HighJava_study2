<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="<%= request.getContextPath() %>/sessionAddServlet.do">Session 정보 저장하기</a>
	<br><br>
	<a href="<%= request.getContextPath() %>/sessionReadServlet.do">Session 정보 확인하기</a>
	<br><br>
	<a href="<%= request.getContextPath() %>/sessionDeleteServlet.do">Session 정보 삭제하기</a>
	<hr>
	
	<%
		// JSP문서에서는 'session'이라는 이름으로 Session객체가 자동을 생성되어 저장되어 있다.
	%>
	세션값(userName) : <%= session.getAttribute("userName") %> <br>
	세션값(age) : <%= session.getAttribute("age") %>
	
	
	

</body>
</html>