<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 재설정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/signup/signup_new_password.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/signup/signup_find_password.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.userNumber}">
			<jsp:include page="/app/header_login.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="/app/header_logout.jsp" />
		</c:otherwise>
	</c:choose>

	<main>
		<section>
			<div class="main-title">Ding Dong Dong!</div>
			<div class="main-container">
				<div class="main-container-title">비밀번호 재설정</div>
				<div class="main-form-container">
					<form action="${pageContext.request.contextPath}/user/resetPwOk.us"
						method="post">
						<div class="main-container-password">
							<div class="main-container-newpassword">
								<div class="main-input-newpassword">
									<div class="main-newpassword-writing">
										<label for="user-password">새 비밀번호</label>
									</div>
									<input type="password" id="user-password" name="userPassword">
								</div>
								<div class=" main-newpassword-message">
									<p>영문,숫자,특수 문자 포함 8자리이상</p>
								</div>
							</div>
							<div class="main-container-checkpassword">
								<div class="main-input-checkpassword">
									<div class="main-checkpassword-writing">
										<label for="user-checkpassword">비밀번호 재입력</label>
									</div>
									<input type="password" id="user-checkpassword"
										name="user-checkpassword">
								</div>
								<div class="main-checkpassword-message">
									<p></p>
								</div>
							</div>
						</div>
						<div class="main-form-button">
							<input type="submit" value="확인">
						</div>
					</form>
				</div>
			</div>
		</section>

	</main>


	<%@ include file="/app/footer.jsp"%>
</body>
</html>