<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>마이페이지 메인(보호소회원)</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage/shelter/archive_list.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/mypage/shelter/archive_list.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/header.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
</head>

<body>
	<!-- header -->
	<!-- 유저 번호 확인 존재시 로그인 헤더 -->
	<c:choose>
		<c:when test="${not empty sessionScope.userNumber}">
			<jsp:include page="/app/header_login.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="/app/header_logout.jsp" />
		</c:otherwise>
	</c:choose>

	<main class="archive-list">

		<div class="container">
			<!-- 사이드바 -->
			<jsp:include page="/app/mypage/sidebar.jsp" />

			<section class="content">
				<div class="content-box">
					<article class="panel panel-center">
						<div class="panel-head">
							<h2 class="panel-title">멍! 카이브 등록 정보</h2>
						</div>

						<div class="panel-body">
							<c:forEach var="item" items="${archiveList}">
								<div class="card-item">
									<div class="card-image-wrapper">
										<c:choose>
											<c:when test="${not empty item.archiveImgPath}">
												<img src="/upload/${item.archiveImgPath}" alt="강아지 이미지">
											</c:when>
											<c:otherwise>
												<span class="no-image">이미지</span>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="card-info">
										<p>${item.dogBreed}| ${item.dogName} | ${item.dogGender}</p>
									</div>
								</div>
							</c:forEach>
						</div>

						<div class="panel-footer">
							<div class="pagination">
								<ul class="page-list" id="pagination"></ul>
							</div>
						</div>
					</article>
				</div>
			</section>
		</div>
	</main>
	<!-- footer -->
	<jsp:include page="/app/footer.jsp" />
	<!-- js -->
	<script src="/assets/js/header-footer.js"></script>
</body>

</html>