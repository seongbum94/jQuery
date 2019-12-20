package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InputMember
 */
@WebServlet("/InputMember")
public class InputMember extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0
		request.setCharacterEncoding("utf-8");
		MemberVO member = new MemberVO();
		
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		/*
		 * String id = request.getParameter("mem_id"); String name =
		 * request.getParameter("mem_name"); String bir =
		 * request.getParameter("mem_bir"); String pass =
		 * request.getParameter("mem_pass"); String hp = request.getParameter("mem_hp");
		 * String zip = request.getParameter("mem_zip"); String add1 =
		 * request.getParameter("mem_add1"); String add2 =
		 * request.getParameter("mem_add2"); String mail =
		 * request.getParameter("mem_mail");
		 * 
		 * member.setMem_id(id); member.setMem_name(name); member.setMem_bir(bir);
		 * member.setMem_pass(pass); member.setMem_hp(hp); member.setMem_zip(zip);
		 * member.setMem_add1(add1); member.setMem_add2(add2); member.setMem_mail(mail);
		 */
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		String resid = service.insertMember(member);
		
		request.setAttribute("resid", resid);
		
		//4 view페이지
		request.getRequestDispatcher("1217/input.jsp").forward(request, response);
	}
}
