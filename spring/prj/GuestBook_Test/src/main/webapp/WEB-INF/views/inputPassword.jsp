<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	삭제 하시겠습니까? 비밀번호를 입력해 주세요.<br>
	<form action="./deleteProcess" method="post">
		<input type="password" name="password">
		<input type="hidden" name="no" value="${no }">
		<input type="submit" value="삭제">
	</form>
</body>
</html>