<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 폼 페이지</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/sessionLoginServlet.do" method="post">
		<table>
		<tr>
			<td>ID : </td>
			<td>
				<input type="text" name="userid" 
						placeholder="ID를 입력하세요" value="">
			</td>
		</tr>
		<tr>
			<td>PASS : </td>
			<td>
				<input type="password" name="pass" 
						placeholder="PASSWORD를 입력하세요" value="">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align:center;">
				<input type="submit" value="LOGIN">
			</td>
		</tr>
		
		</table>
		
	</form>

</body>
</html>