package com.ddd.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.user.dao.UserDAO;
import com.ddd.app.user.dto.UserDTO;

public class SignUpShelterOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();

		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserPassword(request.getParameter("userPassword"));
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setUserNickname(request.getParameter("userNickname"));
		userDTO.setUserGender(request.getParameter("userGender"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		userDTO.setUserPhone(request.getParameter("userPhone"));
		userDTO.setUserEmail(request.getParameter("userEmail"));
		userDTO.setUserType(request.getParameter("userType"));
		userDTO.setShelterName(request.getParameter("shelterName"));
		userDTO.setShelterBusinessNumber(request.getParameter("shelterBusinessNumber"));
		userDTO.setShelterZipcode(request.getParameter("shelterZipcode"));
		userDTO.setShelterAddress(request.getParameter("shelterAddress"));
		userDTO.setShelterAddressDetail(request.getParameter("shelterAddressDetail"));

		userDAO.insertUser(userDTO);
		userDAO.insertUserShelter(userDTO);

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/user/login.us");

		return result;

	}

}
