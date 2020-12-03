<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 결과 페이지</title>

<%--  
<script>
	window.onload = function() {
	
		if(<%= session.getAttribute("loginSession") %>==null) {
			alert("로그인 실패");
			window.history.back();
		}
	}
</script>

  --%>
</head>
<body>

	<%-- 
	<% if(session.getAttribute("loginSession")!=null) {%>
	<p><%= session.getAttribute("userName") %>님 환영합니다.</p>
	<% } %>
	 --%>
	 
	 <%
	 	// JSP문서에서는 세션은 'session'이라는 이름으로 저장되어 있다.
	 	String userId = (String) session.getAttribute("USERID");
	 
	 	if(userId==null) {
	 		
	 %>
	 			<script>
	 				alert("로그인 실패");
	 				//location.href = "이동할 페이지의 URL주소";	// 방법 1
	 				<%-- location.href = "<%= request.getContextPath() %>/03/sessionLogin.jsp";	// 방법 1 --%>
	 				location.href = "<%= request.getContextPath() %>/sessionLoginServlet.do";	// 방법 1
	 				// history.go(-1);	// 방법2
	 			</script>
	 		<%
	 	} else {	// 세션이 있으면
	 		%>
	 			<h3><%= userId %>님 반갑습니다.</h3>
	 			<!-- logoutServlet필요 -->
				<a href="<%= request.getContextPath() %>/sessionLogoutServlet.do">
					LOGIN아웃
				</a>
	 		<%
	 	}
	 
	 %>
	 
	 <%-- 
	 <!-- logoutServlet필요 -->
	<a href="<%= request.getContextPath() %>/sessionLogoutServlet.do">
		LOGIN아웃
	</a>
	 --%>	
	


	
	
</body>
</html>