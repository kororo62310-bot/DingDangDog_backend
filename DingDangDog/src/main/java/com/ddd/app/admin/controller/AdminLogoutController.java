package com.ddd.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;

public class AdminLogoutController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		HttpSession session = request.getSession();

		session.invalidate();

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/admin/adminLogin.ad");

		return result;
	}

}
