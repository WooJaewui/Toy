<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
	  <a href="../main/index.do"><img id="logo" src="../resources/img/logo.png"></a>
	<nav id="top_menu">
	  <a href="../main/index.do">HOME</a> | 
	  <c:choose>
	  	<c:when test="${empty sessionUser }">
	  		<a href="../member/loginPage.do">LOGIN</a> |
	  	</c:when>
	  	<c:otherwise>
	  		<a href="../member/logoutProcess.do?pageId=1">LOGOUT</a> |
	  	</c:otherwise>
	  </c:choose>
	  <a href="../member/joinMember.do">JOIN</a>
	</nav>
	<nav id="main_menu">
	  <ul>
	    <li><a href="../board/boardListPage.do?start=1&end=10">자유 게시판</a></li>
	    <li><a href="#">기타 연주</a></li>
	    <li><a href="#">공동 구매</a></li>
	    <li><a href="#">연주회 안내</a></li>
	    <li><a href="#">회원 게시판</a></li>
	  </ul>
	</nav>
	</header> <!-- header -->