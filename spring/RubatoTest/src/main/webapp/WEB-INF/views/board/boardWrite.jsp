<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_left.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_write_main.css">
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
      <li><a href="./boardListPage.do">+ 자유 게시판</a></li>
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
  <div id="write_title"><h2>글쓰기</h2></div>						
  <form action="./boardWriteProccess.do" method="post" enctype="multipart/form-data">
  	  <input type="hidden" name="member_no" value="${sessionUser.no }">
	  <table>
	    <tr id="name">
	      <td class="col1">이름</td>
	      <td class="col2">${sessionUser.id }</td>
	    </tr>
	    <tr id="subject">
	      <td class="col1">제목</td>
	      <td class="col2"><input type="text" name="title"></td>
	    </tr>		
	    <tr id="content">
	      <td class="col1">내용</td>
	      <td class="col2"><textarea name="content"></textarea></td>
	    </tr>	
	    <tr id="upload">
	      <td class="col1">업로드 파일</td>
	      <td class="col2"><input type="file" name="multiFile"></td>
   		</tr>	
	  </table>
	  <div id="buttons">
	    <input type="submit" value="완료"> 
	    <a href="./boardListPage.do">목록</a>
	  </div>
  </form>
</section> <!-- section main -->
<div class="clear"></div>

<!-- footer -->
<jsp:include page="../common/footer.jsp" />

</div> <!-- wrap -->
</body>
</html>
