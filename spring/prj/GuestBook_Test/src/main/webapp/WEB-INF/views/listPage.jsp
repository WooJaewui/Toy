<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
<%-- 	<c:choose>
		<c:when test="${empty guestBookList }">
			아직 작성된 글이 없습니다.. 글을 작성해주세요!!
		</c:when>
		<c:otherwise>
			<c:forEach items="${guestBookList }" var="data"> 
				내용 : ${data.content } 
				/ 작성자 : ${data.nick } 
				<a href="./deletePage?no=${data.no }">X</a>
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose> --%>
	<c:forEach items="${guestBookList }" var="data"> 
				내용 : ${data.content } 
				/ 작성자 : ${data.nick } 
				<a href="./deletePage?no=${data.no }">X</a>
				<br>
			</c:forEach>
	<br><br>
	
	<a href="./writePage">글쓰기</a>
</body>
</html>