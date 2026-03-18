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

import jdk.javadoc.internal.doclets.toolkit.taglets.UserTaglet;

public class CheckPasswordController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("===CheckPasswordController 실행===");

		HttpSession session = request.getSession();
		UserDTO userDTO = new UserDTO();
		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();
		int loginUserNumber = (Integer) session.getAttribute("userNumber");
		String loginUserType = (String) session.getAttribute("userType");
		String InputPassword = request.getParameter("checkPassword");
		String path = null;

		System.out.println(loginUserNumber);
		System.out.println(loginUserType);
		System.out.println(InputPassword);

		userDTO.setUserNumber(loginUserNumber);
		;
		userDTO.setUserPassword(InputPassword);

		int test = mypageDAO.checkPassword(userDTO);

		if (test == 1) {
			if(loginUserType == "C") {
				path = request.getContextPath() + "/mypage/profileEditC.mp";
			} else if (loginUserType == "S") {
				path = request.getContextPath() + "/mypage/profileEditS.mp";
			}
			
		} else {
			path = request.getContextPath() + "/mypage/checkPw.mp?checkPw=fail";
		}

		result.setRedirect(true); // 세션에 저장된 값은 유지
		result.setPath(path);

		return result;
	}

}
