document.addEventListener("DOMContentLoaded", function() {
	const resetForm = document.querySelector("form");
	const newPw = document.getElementById("user-password");
	const newPwCheck = document.getElementById("user-checkpassword");
	const submitBtn = document.querySelector(".main-form-button input");

	const pwGuide = document.querySelector(".main-newpassword-message p");
	const pwCheckMsg = document.querySelector(".main-checkpassword-message p");

	let isPasswordValid = false;
	let isPasswordMatch = false;


	function validatePassword() {
		const pwValue = newPw.value;
		const pwCheckValue = newPwCheck.value;

		// 정규식: 영문, 숫자, 특수문자 포함 8자 이상
		const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

		// 1. 비밀번호 형식 검사
		if (pwValue === "") {
			isPasswordValid = false;
		} else if (pwRegex.test(pwValue)) {
			pwGuide.style.color = "gray";
			pwGuide.textContent = "사용 가능한 비밀번호 형식입니다";
			isPasswordValid = true;
		} else {
			pwGuide.style.color = "red";
			pwGuide.textContent = "영문, 숫자, 특수 문자 포함 8자리 이상이어야 합니다";
			isPasswordValid = false;
		}

		if (pwCheckValue === "") {
			pwCheckMsg.style.visibility = "hidden";
			isPasswordMatch = false;
		} else if (pwValue === pwCheckValue) {
			pwCheckMsg.style.visibility = "visible";
			pwCheckMsg.style.color = "green";
			pwCheckMsg.textContent = "비밀번호가 일치합니다.";
			isPasswordMatch = true;
		} else {
			pwCheckMsg.style.visibility = "visible";
			pwCheckMsg.style.color = "red";
			pwCheckMsg.textContent = "비밀번호가 일치하지 않습니다.";
			isPasswordMatch = false;
		}
	}

	newPw.addEventListener("input", validatePassword);
	newPwCheck.addEventListener("input", validatePassword);

	resetForm.addEventListener("submit", (e) => {

		if (!isPasswordValid || !isPasswordMatch) {
			alert("비밀번호를 다시 확인해주세요");
			e.preventDefault();
			return;
		}

		alert("비밀번호 변경이 완료되었습니다. 로그인 페이지로 이동합니다.");
	});
});