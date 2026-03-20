package com.ddd.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;

public class ResetPwController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ResetPwController 실행");
		
		Result result = new Result();
		HttpSession session = request.getSession();

		Integer userNumber = (Integer) session.getAttribute("resetUserNumber");

		if (userNumber == null) {
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/user/findPw.us");
		} else {
			result.setRedirect(false);
			result.setPath("/app/signup/signup_new_password.jsp");
		}

		return result;
	}
}
