package com.ddd.app.dogcare.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareDTO;
import com.ddd.app.dogcare.dto.CareDetailDTO;

public class CareUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("=== CareUpdateController 실행 ===");

		Result result = new Result();
		CareDAO careDAO = new CareDAO();


		if(request.getMethod().equalsIgnoreCase("GET")) {

			int careNumber = Integer.parseInt(request.getParameter("careNumber"));
			System.out.println("수정할 글 번호 : " + careNumber);

			CareDetailDTO care = careDAO.selectCare(careNumber);
			System.out.println("조회된 데이터 : " + care);

			request.setAttribute("care", care);

			result.setPath("/app/dogcare/careUpdate.jsp");
			result.setRedirect(false);
			return result;
		}


		request.setCharacterEncoding("UTF-8");

		CareDTO careDTO = new CareDTO();

		careDTO.setCareNumber(Integer.parseInt(request.getParameter("careNumber")));
		careDTO.setCareTitle(request.getParameter("careTitle"));
		careDTO.setCarePost(request.getParameter("carePost"));
		careDTO.setCareDate(Date.valueOf(request.getParameter("careDate")));
		careDTO.setCareRecruit(Integer.parseInt(request.getParameter("careRecruit")));
		System.out.println("수정 DTO : " + careDTO);

		careDAO.updateCare(careDTO);
		System.out.println("수정 완료");


		result.setPath(request.getContextPath() + "/care/detail.ca?careNumber=" + careDTO.getCareNumber());
		result.setRedirect(true);

		return result;
	}
	
}
