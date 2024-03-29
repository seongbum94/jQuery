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
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class lprodServlet
 */
@WebServlet("/lprodServlet")
public class lprodServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트에서 전송시 파라미터를 전달 받는다.
		
		//1. Service객체 얻기
		ILprodService service = LprodServiceImpl.getInstance();
		
		//2. Service메소드 호출 - 결과값 받기
		List<LprodVO> list = service.selectLprod();
		
		//3. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4. view페이지로 이동(forward) - 결과값을 출력한다.
		RequestDispatcher disp = request.getRequestDispatcher("1216/lprodList.jsp");
		disp.forward(request, response);
	}
}
