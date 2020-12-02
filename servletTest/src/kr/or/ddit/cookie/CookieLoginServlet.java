package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// userid, pass, chkid 값 받아오기
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String checkid = request.getParameter("chkid");
		
		// 쿠키 객체 생성
		Cookie cookie = new Cookie("USERID", userid);
		
		// 체크 박스의 체크 여부에 따라서 쿠키를 저장하거나 삭제한다.
		if(checkid != null) {	// 체크박스가 체크되었을 때
			
			response.addCookie(cookie);	// 쿠키 저장
		} else {
			
			cookie.setMaxAge(0);	// 쿠키의 유효시간을 0으로 설정하여 쿠키가 삭제되도록 한다.
			response.addCookie(cookie);
		}
		
		String contextPath = request.getContextPath();
		
		// userid, pass의 null여부 체크 ==> 가져온 파라미터 값들의 null값 여부는 반드시 검사하는 것이 좋다.
		if(userid != null && pass != null) {
			
			if("test".equals(userid) && "1234".equals(pass)) {	// 로그인 성공
				
				// cookieMain.jsp로 이동
				response.sendRedirect(contextPath + "/02/cookieMain.jsp");
			} else {	// 로그인 실패
				// cookieLogin.jsp로 이동
				response.sendRedirect(contextPath + "/02/cookieLogin.jsp");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
