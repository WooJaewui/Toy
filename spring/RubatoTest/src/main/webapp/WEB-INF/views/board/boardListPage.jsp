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
  <link rel="stylesheet" type="text/css" href="../resources/css/board_list_main.css">
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
	    <li><a href="../board/boardListPage.do">자유 게시판</a></li>
	    <li><a href="#">기타 연주</a></li>
	    <li><a href="#">공동 구매</a></li>
	    <li><a href="#">연주회 안내</a></li>
	    <li><a href="#">회원 게시판</a></li>
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
    <div id="total_search">
      <div id="total">▷ 총 ${countList }개의 게시물이 있습니다.</div>
      <div id="search">
        <div id="select_img"><img src="../resources/img/select_search.gif"></div>
	        <form action="searchBoardList.do" method="get">
		        <div id="search_select">
			        <select name="searchSelect">
			        	<option value="title">제목</option>
			            <option value="content">내용</option>
			            <option value="nick">글쓴이</option>
			        </select> 
			    </div>
			        <div id="search_input"><input type="text" name="searchString"></div>
			        <div id="search_btn"><input type="submit" value="검색"></div>
	       	</form>
      </div>
    </div>
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>일시</th>
        <th>조회수</th>
      </tr>
      
      	<c:forEach items="${list }" var="data">
      		<tr>
		        <td class="col1">${data.boardVo.no }</td>
		        <td class="col2" style="text-align: center;">
		          <a href="./readContentPage.do?no=${data.boardVo.no }">${data.boardVo.title }</a>
		        </td>
		        <td class="col3">${data.memberVo.nick }</td>
		        <td class="col4">${data.boardVo.writeDate }</td>
		        <td class="col5">${data.boardVo.readCount }</td>
        	</tr>
        </c:forEach>
  	</table>
    <div id="buttons">
      <div class="col1">
      	<a>◀ 이전</a>
      	<c:forEach begin="1" end="${page.totalPage }" varStatus="status">
      		<a href="./boardListPage.do?start=${((status.count-1)*10)+1 }&end=${status.count*10}">${status.count }</a> 
      	</c:forEach>
      	<a>다음 ▶</a>
      </div>
      <div class="col2">
        <a href="./boardListPage.do?start=1&end=10"><img src="../resources/img/list.png"></a>
        <c:if test="${!empty sessionUser }">
        	<a href="./boardWrite.do"><img src="../resources/img/write.png"></a>
        </c:if>
      </div>
    </div>
  </section> <!-- section main -->
  <div class="clear"></div>
	<!-- footer -->
	<jsp:include page="../common/footer.jsp" />
</div> <!-- wrap -->
</body>
</html>