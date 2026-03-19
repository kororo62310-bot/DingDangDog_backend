package com.ddd.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.admin.dao.AdminDAO;
import com.ddd.app.admin.dto.AdminCareDTO;

public class AdminCareDetailOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=== AdminCareDetailOkController 실행 ===");
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		
		AdminCareDTO detail = adminDAO.selectCareDetail(careNumber);
		AdminCareDTO status = adminDAO.selectApplyStatus(careNumber);
		List<AdminCareDTO> applyList = adminDAO.selectApplyList(careNumber);
		
		request.setAttribute("adminCare", detail);
		System.out.println("상세정보 출력");
		request.setAttribute("adminCare", status);
		System.out.println("신청현황 출력");
		request.setAttribute("adminCare", applyList);
		System.out.println("신청자 목록 출력");
		
		
		result.setPath("/app/admin/dogcare/admin_dogcare_detail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
