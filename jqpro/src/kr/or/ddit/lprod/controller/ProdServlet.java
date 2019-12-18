package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.ProdVO;

@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트에서 전송시 파라미터를 전달 받는다.
		String lprod_gu = request.getParameter("lprod_gu");
		
		//1. Service객체 얻기
		ILprodService service = LprodServiceImpl.getInstance();
		
		//2. Service메소드 호출 - 결과값 받기
		List<ProdVO> list = service.selectProd(lprod_gu);
		
		//3. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4. view페이지로 이동(forward) - 결과값을 출력한다.
		//RequestDispatcher disp = request.getRequestDispatcher("1216/prodNames.jsp");
		RequestDispatcher disp = request.getRequestDispatcher("1216/prodswNames.jsp");
		disp.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 클라이언트 요청시 값을 전달 받는다.
		String prod_id = request.getParameter("prod_id");		//ajax의 data에서 가져옴
		
		//1. service 객체 얻기
		ILprodService service =	LprodServiceImpl.getInstance();
		
		//2. service 메소드 호출
		ProdVO vo = service.prodDetail(prod_id);
		
		//3. request 결과 값저장
		request.setAttribute("vo", vo);		//request는 응답하면 사라짐
		
		//4. view 페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher("1216/prodDetail.jsp");
		disp.forward(request, response);
	}
}





