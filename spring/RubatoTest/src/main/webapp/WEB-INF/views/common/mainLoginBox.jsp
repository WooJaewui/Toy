<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article id="login_box">
	    <img id="login_title" src="../resources/img/ttl_login.png">
	    <c:choose>
	    	<c:when test="${empty sessionUser }">
	    		<div id="input_button">
				    <form action="../member/loginProcess.do?pageId=0" method="post">
					    <ul id="login_input">
					    	<li><input type="hidden" name="pageId" value="1"></li>
					    	<li><input type="text" name="id"></li>
					    	<li><input type="password" name="pw"></li>
					    </ul>
					    <button><img id="login_btn" src="../resources/img/btn_login.gif"></button>
					    <!-- <input type="image" src="../resources/img/btn_login.gif"> -->
				    </form>
			    </div> 
			    <div class="clear"></div>
			    <div id="join_search">
			      <a href="../member/joinMember.do"><img src="../resources/img/btn_join.gif"></a>
			      <img src="../resources/img/btn_search.gif">
			 	</div>
	    	</c:when>
	    	<c:otherwise>
	    		<br><br><br>
	    		<h3 style="margin-left: 10px"> ${sessionUser.nick }님이 로그인했습니다.</h3><br>
	    		<a href="../member/logoutProcess.do?pageId=0" style="margin-left: 10px">로그아웃</a>
	    	</c:otherwise>	
		 </c:choose>
	  </article>