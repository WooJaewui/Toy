<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_left.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_view_main.css">
</head>
<body>
<div id="wrap">

	<!-- header -->
	<jsp:include page="../common/header.jsp"/>
	
<aside>
 	<!-- loginBox -->
	<jsp:include page="../common/listLoginBox.jsp"/>
	
  <nav id="sub_menu">
    <ul>
      <li><a href="board_list.html">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="../resources/img/banner1.png"></li>
      <li><img src="../resources/img/banner2.png"></li>		
      <li><img src="../resources/img/banner3.png"></li>
    </ul>	
  </article>
</aside> 

<section id="main">
  <img src="../resources/img/comm.gif">
  <h2 id="board_title">자유 게시판 </h2>
  <div id="view_title_box"> 
    <span>까스통님의 선물인 보드카가 정말 독하네요!!!</span>
    <span id="info">${data.memberVo.nick } | 
    				조회 : ${data.boardVo.readCount } | 
    				${data.boardVo.writeDate }</span>
  </div>	
  <p id="view_content">
  	${data.boardVo.content }
  </p>
  <hr>
  <div>
	<c:if test="${!empty commentList }">
		<c:forEach items="${commentList }" var="data2">
				${data2.comment }
			<c:if test="${data.boardVo.member_no == sessionUser.no }">
				<a href="./deleteBoardComment.do?board_no=${data.boardVo.no }&no=${data2.no }&member_no=${sessionUser.no}">
					댓글지우기
				</a>
			</c:if>
			<br>
		</c:forEach>
	</c:if>  	
  	
  </div>
  <div id="comment_box">
  	<form action="./createBoardComment.do">
	    <img id="title_comment" src="../resources/img/title_comment.gif">
	    <input type="hidden" name="board_no" value="${data.boardVo.no }">
	    <input type="hidden" name="member_no" value="${sessionUser.no }">
	    <textarea name="comment"></textarea>
	    <input type="submit" value="댓글쓰기" style="float: right;">
    </form>
  </div>
  <div id="buttons">
    <a href="#"><img src="../resources/img/delete.png"></a>		
    <a href="./boardListPage.do"><img src="../resources/img/list.png"></a>
    <a href="./boardWrite.do"><img src="../resources/img/write.png"></a>			
  </div>
</section> <!-- section main -->
<div class="clear"></div>
<jsp:include page="../common/footer.jsp" />
</div> <!-- wrap -->
</body>
</html>