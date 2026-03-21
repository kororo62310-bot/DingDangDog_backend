
function applyClick(careNumber) {
	// 세션에서 userNumber 값 가져오기
	var userNumber = '<c:out value="${sessionScope.userNumber}" />';

	// userNumber가 비어있으면 로그인하지 않은 상태
	if (!userNumber || userNumber === '') {
		alert("로그인이 필요한 서비스입니다.");
		// 로그인 페이지로 리다이렉트
		window.location.href = "${pageContext.request.contextPath}/login.jsp";
	} else {
		// userNumber가 있는 경우, 신청 처리 페이지로 리다이렉트
		window.location.href = "${pageContext.request.contextPath}/care/apply.ca?careNumber="
			+ careNumber + "&userNumber=" + userNumber;
	}
}
