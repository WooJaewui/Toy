<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String[] dog = request.getParameterValues("dog");
	String pu = "";
	String jin = "";
	String pung = "";
	String sap = "";
	
	if(dog == null){
		out.println("좋아하는 강아지가 없습니다.");
	} else{
		for(int i=0; i<dog.length; i++){
			switch(dog[i]){
			case "푸들" :
				pu = "./source/pu.jpg";
				break;
			case "진돗개" :
				jin = "./source/jin.jpg";
				break;
			case "풍산개" :
				pung = "./source/pung.jpg";
				break;
			case "삽살개" :
				sap = "./source/sap.jpg";
				break;
			}
		}
	} 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="<%=pu %>">
	<img src="<%=jin %>">
	<img src="<%=pung %>">
	<img src="<%=sap %>">
</body>
</html>