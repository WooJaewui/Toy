<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	id(request) : <%=request.getAttribute("id") %><br>
	pw(request) : ${pw }<br><br>
	
	id(param) : <%=request.getParameter("id") %><br>
	pw(param) : ${param.pw }<br>
</body>
</html>