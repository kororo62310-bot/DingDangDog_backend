package com.ddd.app.dogcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareApplyDTO;

public class CareApplyController implements Execute {

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("=== CareApplyController 실행 ===");

	    CareDAO careDAO = new CareDAO();
	    CareApplyDTO dto = new CareApplyDTO();
	    Result result = new Result();
	    
	    // 게시글 번호와 회원 번호 받기
	    int careNumber = Integer.parseInt(request.getParameter("careNumber"));
	    int userNumber = Integer.parseInt(request.getParameter("userNumber"));
	    
	    dto.setCareNumber(careNumber);
	    dto.setUserNumber(userNumber);

	    // 세션에서 userNumber 가져오기 (로그인된 사용자)
	    int sessionUserNumber = (Integer) request.getSession().getAttribute("userNumber");
	    
	    // 세션의 userNumber와 요청된 userNumber가 일치하는지 확인
	    if (sessionUserNumber != userNumber) {
	        // 세션과 요청된 userNumber가 다르면 로그인한 사용자 정보와 다르므로 오류 처리
	        result.setPath("/errorPage.jsp");
	        result.setRedirect(true);
	        return result;
	    }

	    // 중복 신청 체크
	    int count = careDAO.checkDuplicateApply(careNumber, userNumber);
	    
	    if (count > 0) {
	        // 이미 신청한 경우, alertMessage를 설정
	        request.setAttribute("alertMessage", "이미 신청된 봉사입니다.");
	        result.setPath("/care/detail.ca?careNumber=" + careNumber);  // 상세 페이지로 리다이렉트
	        result.setRedirect(false);  // 포워드 방식으로 메시지와 함께 리다이렉트
	        return result;
	    }

	    // 봉사 신청
	    careDAO.applyCare(dto);
	    
	    // 봉사 신청 인원 수 증가
	    careDAO.incrementApplyCount(careNumber);
	    
	    // 신청 완료 메시지 설정
	    request.setAttribute("alertMessage", "신청 완료되었습니다.");
	    
	    // 신청 후 상세페이지로 리다이렉트
	    result.setPath("/care/detail.ca?careNumber=" + careNumber);
	    result.setRedirect(false);  // 포워드 방식으로 메시지와 함께 리다이렉트

	    return result;
	}
}