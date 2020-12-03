package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/sessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String userid = "";
	String pass = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		
		if("admin".equals(userid) && "1234".equals(pass)) {	
			response.sendRedirect(contextPath + "/03/sessionResult.jsp");
		} else {
			response.sendRedirect(contextPath + "/03/sessionLogin.jsp");
		}
		*/
		
		// GET방식으로 요청하면 세션을 확인해서 세션이 없으면 로그인 폼(sessionLogin.jsp)으로 이동
		// 세션이 있으면 sessionResult.jsp로 이동
		
		HttpSession session = request.getSession();
		String viewPage = null;
		
		String userId = (String) session.getAttribute("USERID");
		if(userId == null) {	// 세션값이 없으면...
			
			viewPage = "/03/sessionLogin.jsp";
		} else {
			viewPage = "/03/sessionResult.jsp";
		}
		
		// 페이지 이동하기 ==> forward방식과 redirect방식 중 하나를 사용한다.
		// 방법1) redirect방식
		response.sendRedirect(request.getContextPath() + viewPage);
		
		// 방법2) forward방식
		//RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		//rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// userid, pass값 받아오기
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		// session 객체 생성
		HttpSession session = request.getSession();
		
		
		session.setAttribute("userName", userid);
		session.setAttribute("pass", pass);
		
		
		String contextPath = request.getContextPath();
		
		// userid, pass의 null여부 체크 ==> 가져온 파라미터 값들의 null값 여부는 반드시 검사하는 것이 좋다.
		if(userid != null && pass != null) {
			
			if("admin".equals(userid) && "1234".equals(pass)) {	// 로그인 성공
				session.setAttribute("loginSession", "로그인 성공했습니다.");
				// sessionResult.jsp로 이동
				response.sendRedirect(contextPath + "/03/sessionResult.jsp");
			} else {	// 로그인 실패
				// sessionResult.jsp로 이동
				session.setAttribute("loginSession", null);
				
				response.sendRedirect(contextPath + "/03/sessionResult.jsp");
			}
		}
		*/
		
		// POST 방식으로 요청하면 로그인 검증 작업을 수행한다.
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		String viewPage = "/03/sessionResult.jsp";
		
		HttpSession session = request.getSession();
		
		if((userId!=null) && (pass!=null)) {
			
			if("admin".equals(userId) && "1234".equals(pass)) {	// 로그인 성공
				
				session.setAttribute("USERID", userId);
			}
		}

		// 페이지 이동하기 ==> forward방식과 redirect방식 중 하나를 사용한다.
		// 방법1) redirect방식
		//response.sendRedirect(request.getContextPath() + viewPage);
		
		// 방법2) forward방식
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
		
	}

}
