package com.ddd.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.user.dao.UserDAO;
import com.ddd.app.user.dto.UserDTO;

public class SignUpCommonOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();

		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserPassword(request.getParameter("userPassword"));
		userDTO.setUserNickname(request.getParameter("userNickname"));
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setUserGender(request.getParameter("userGender"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		userDTO.setUserPhone(request.getParameter("userPhone"));
		userDTO.setUserEmail(request.getParameter("userEmail"));
		userDTO.setUserType(request.getParameter("userType"));

		userDAO.insertUser(userDTO);
		userDAO.insertCommonUser(userDTO);

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/user/login.us");

		return result;
	}

}
