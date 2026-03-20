package com.ddd.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.user.dao.UserDAO;
import com.ddd.app.user.dto.UserDTO;

public class ResetPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ResetPwOkController 실행");
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		HttpSession session = request.getSession();

		Integer userNumber = (Integer) session.getAttribute("resetUserNumber");
		String userPassword = request.getParameter("userPassword");

		System.out.println(userNumber + "," + userPassword);
		userDTO.setUserNumber(userNumber);
		userDTO.setUserPassword(userPassword);

		userDAO.resetPw(userDTO);

		session.removeAttribute("resetUserNumber");

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/user/login.us");

		return result;

	}

}
