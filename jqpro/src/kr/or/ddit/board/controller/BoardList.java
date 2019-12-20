package kr.or.ddit.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0 클라이언트에서 전송된 값을 가져온다
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		List<BoardVO> list = null;
		
		//1. service객체 만들기
		IBoardService service = BoardServiceImpl.getInstance();
		//2. service메소드 호출하기 - 결과값 받기
		try {
			 list = service.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 결과값 request에 저장하기
		request.setAttribute("list", list);
		
		//4. view페이지로 forward
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}
}
