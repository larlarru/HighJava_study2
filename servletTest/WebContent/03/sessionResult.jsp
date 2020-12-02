<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 
<script>
	window.onload = function() {
	
		if(<%= session.getAttribute("loginSession") %>==null) {
			alert("로그인 실패");
			window.history.back();
		}
	}
</script>

 
</head>
<body>
	
	<% if(session.getAttribute("loginSession")!=null) {%>
	<p><%= session.getAttribute("userName") %>님 환영합니다.</p>
	<% } %>
		
	<!-- logoutServlet필요 -->
	<a href="<%= request.getContextPath() %>/sessionLogoutServlet.do">
		LOGIN아웃
	</a>


	
	
</body>
</html>