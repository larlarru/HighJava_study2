package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 애너테이션에 서블릿 초기화 파라미터 설정하는 예제
@WebServlet(urlPatterns = "/servletTest06.do",
			initParams = {
					@WebInitParam(name="email", value="admin@gmail.com"),
					@WebInitParam(name="name", value="성충향")
					}
			)

public class ServletTest06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		String email = getInitParameter("email");
		String name = config.getInitParameter("name");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>초기화 파라미터 연습</title></head>");
		out.println("<body>");
		out.println("<h2>서블릿 초기화 파라미터</h2>");
		out.println("이메일 : " + email + "<br>");
		out.println("이름 : " + name + "<br>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
