package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionResultServlet
 */
@WebServlet("/sessionLogoutServlet.do")
public class SessionLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		
		response.sendRedirect(contextPath + "/03/sessionMain.jsp");
		*/
		
		// 세션을 삭제한 후 sessionMain.jsp로 이동
		HttpSession session = request.getSession();
		
		//session.removeAttribute("USERID");	// 방법1
		session.invalidate();	// 방법2
		
		response.sendRedirect(request.getContextPath() + "/03/sessionMain.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
