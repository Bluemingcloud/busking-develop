<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< Updated upstream
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="../resources/css/customer_center/customer_center_index.css">

<!-- 부트스트랩 css링크 -->
<link rel="stylesheet"
	href="../resources/css/customer_center/bootstrap.min.css">
<!-- 제이쿼리(부스트랩보다 먼저 링크) -->
<script src="../resources/js/customer_center_js/jquery-3.7.1.min.js"></script>
<!-- 부트스트랩 js링크 -->
<script src="../resources/js/customer_center_js/bootstrap.min.js"></script>

<!-- 커스터마이징 한 css 디자인 추가 -->
<link rel="stylesheet" href="../resources/css/custom-reset.css">
<link rel="stylesheet" href="../resources/css/center_default.css">
<link rel="stylesheet"
	href="../resources/css/customer_center/customer_center_index_board.css">


<!-- header,footer -->
<link rel="stylesheet"
	href="../resources/css/customer_center/customer_center_header_footer.css">

</head>

<%@ include file="../include/header.jsp"%>


<body>

	<!-- 중앙 레이아웃 -->
	<section class="container customer-center-width" id="change">
		<div class="row">
=======
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

    <!-- 중앙 레이아웃 -->
    <section class="container customer-center-width" id="change">
        <div class="row">
>>>>>>> Stashed changes

			<!-- 좌측메뉴 -->
			<div class="col-xs-12 col-sm-12 col-lg-12 col-lg-12 content">
				<li class="col-xs-4 col-sm-4 col-lg-4 col-lg-4">
					<section>
						<div class="service_menu">
							<nav>
								<div class="span"></div>
								<h1>고객센터</h1>
								<ul class="menu">
									<li class="nth1"><strong><a
											href="customer_center_index.customer"><span>공지사항</span></a></strong></li>
									<li class="nth2"><strong><a
											href="customer_center_month.customer"><span>이달의예약</span></a></strong>
									</li>
									<li class="nth3"><strong><a
											href="customer_center_guide.customer"><span>이용안내</span></a></strong></li>
									<li class="nth4"><strong><a
											href="customer_center_FAQ.customer"><span>자주묻는질문(FAQ)</span></a></strong>
									</li>
								</ul>
							</nav>
						</div>
					</section>
				</li>
			</div>

			<!-- 공지사항 게시판 > 게시글 내용 보는 곳 -->
			<div class="col-xs-12 col-sm-12 col-lg-12 col-lg-12 board">
				<div class="service-board">
					<div class="container">
						<div class="page-header">
							<h2>공지사항</h2>
						</div>
						<p>게시글 내용 보는 페이지</p>

						<!-- 글 내용 -->
						<div class="panel panel-default">
							<div class="panel-heading">${dto.noticeTitle }</div>
							<div class="panel-body">
								<p>${dto.noticeContent }</p>
							</div>

							<!-- 글 목록, 수정, 삭제 버튼-->
							<div class="board_button_set">
								<div class="board-button">
									<a href="customer_center_index.customer"><button
											type="button" class="btn btn-default">목록</button></a>
								</div>

								<div class="board-button">
									
                                   
                     				
                     				<input type="button" value="수정" onclick="location.href='modify.customer?noticeNum=${dto.noticeNum}';">&nbsp;&nbsp;
                                    
                                            
                                    
								</div>

								<div class="board-button">
									<a href="customer_center_index_content_delete.customer">
										<button type="button" class="btn btn-default"
											onclick="alert('삭제되었습니다');">삭제</button>
									</a>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>


			<div class="col-xs-12 col-sm-12 col-lg-12 col-lg-12 extra">
				<!-- 빈칸1 -->
			</div>

			<!-- <div class="col-xs-12 col-sm-12 col-lg-12 col-lg-12 extra">
                빈칸2
            </div> -->

		</div>
	</section>

<<<<<<< Updated upstream

	<%@ include file="../include/footer.jsp"%>

</body>


</html>
=======
   
<%@ include file="../include/footer.jsp"%>
>>>>>>> Stashed changes
