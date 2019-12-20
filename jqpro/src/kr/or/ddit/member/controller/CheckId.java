package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/CheckId")
public class CheckId extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 전송시에 값을 전달 받는다.
		String inputid = request.getParameter("id");
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2. service 메소드 호출
		String res = service.checkId(inputid);
		
		//3. 결과값을 request에 저장한다.
		request.setAttribute("resid", res);	//a001, null
		request.setAttribute("inputid", inputid);	//a001
		
		//5. view 페이지로 넘어간다
		request.getRequestDispatcher("1217/checkid.jsp").forward(request, response);
	}
}
