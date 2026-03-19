package com.ddd.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.mypage.dao.MypageDAO;
import com.ddd.app.user.dto.UserDTO;

public class ProfileCEditController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();
		UserDTO userDTO = new UserDTO();

		Integer userNumber = (Integer) session.getAttribute("userNumber");

		userDTO = mypageDAO.selectMyPageInfo(userNumber);

		request.setAttribute("user", userDTO);

		result.setRedirect(false);
		result.setPath("/app/mypage/common/profile_edit_common.jsp");

		return result;
	}

}
