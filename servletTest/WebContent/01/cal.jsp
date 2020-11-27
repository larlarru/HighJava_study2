<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="cal" action="/servletTest/cal.do" method="post">
		<input type="text" name="num1">
		
		<select name="calType">
			<option value="+">+</option>
			<option value="-">-</option>	
			<option value="*">*</option>	
			<option value="/">/</option>	
			<option value="%">%</option>	
		</select>
	
		<input type="text" name="num2">
		
		<input type="submit" value="확인" name="res">
	</form>
	
	
</body>
</html>