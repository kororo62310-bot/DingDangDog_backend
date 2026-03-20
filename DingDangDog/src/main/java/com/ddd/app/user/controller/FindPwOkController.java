package com.ddd.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.user.dao.UserDAO;
import com.ddd.app.user.dto.UserDTO;

public class FindPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("FindPwOkController");
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();

		String userId = request.getParameter("userId");
		String userPhone = request.getParameter("userPhone");

		userDTO.setUserId(userId);
		userDTO.setUserPhone(userPhone);

		Integer userNumber = userDAO.findPw(userDTO);

		System.out.println("userNumber " + userNumber);

		if (userNumber != null) {
			request.getSession().setAttribute("resetUserNumber", userNumber);
			result.setPath(request.getContextPath() + "/user/resetPw.us");
		} else {
			result.setPath(request.getContextPath() + "/user/findPw.us?find=fail");
		}
		result.setRedirect(true);

		return result;

	}

}
