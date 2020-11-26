package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletTest07.do")
public class ServletTest07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 컨텍스트 초기화 파라미터 ==> 웹 애플리케이션 전체에 속하는 초기화 파라미터
		 * 
		 * web.xml 파일의 <web-app>엘리먼트 바로 아래의 자식 엘리먼트로<context-param>이라는
		 * 이름으로 작성한다.
		 * 이 <context-param>엘리먼트는 <param-name>과 <param-value>의 자식 엘리먼트가 있다.
		 * 
		 * Servlet 클래스에서는 getServletContext()메서드를 이용해서  ServletContext객체를
		 * 구하고, 이 객체의 getInitParameter()메서드를 호출하여 사용한다.
		 * 형식) getInitParameter("파라미터명");
		 * 
		 */
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		String param = context.getInitParameter("myContext");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>초기화 파라미터 연습</title></head>");
		out.println("<body>");
		out.println("<h2>서블릿 초기화 파라미터</h2>");
		out.println("myContext : " + param + "<br>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
