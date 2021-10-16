<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록 쓰기</h1>

	<form action="./writeProcess" method="post">
		작성자 : <input type="text" name="nick"><br>
		내용 : <input type="text" name="content"><br>
		비밀번호 : <input type="password" name="password"><br>
		<input type="submit" value="작성 완료" >
	</form>
</body>
</html>
