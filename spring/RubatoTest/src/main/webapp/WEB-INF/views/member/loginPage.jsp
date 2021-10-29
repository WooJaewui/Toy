<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="./loginProcess.do" method="post">
		<input type="hidden" name="pageId" value="0">
		id : <input type="text" name="id"><br>
		pw : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="./joinMember.do">회원가입</a>
</body>
</html>