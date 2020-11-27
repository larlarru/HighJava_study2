package kr.or.ddit.reqres;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * - redirect
		 * 다른 페이지로 넘어가도록 한다. (직접 파라미터를 넘길 수 없다.)
		 * redirect명령은 넘어갈 URL 주소를 클라이언트에게 전달하고, 클라이언트(웹브라우저)가
		 * 넘어갈 URL주소로 새로운 요청을 하고 그에  따른 응답을 하는 과정으로 처리된다.
		 * 
		 * URL주소로 넘어가기 때문에 주소의 길이에 제한이 있다.
		 * 이것은 성격이 서로 다른 페이지나 서블릿이 그 길을 알려주고 브라우저가 받아오게 하는 것이다.
		 * 
		 * redirect명령은 HttpServletResponse객체의 sendRedirect()메서드이다.
		 * 이 메서드에 이동할 페이지의 URL주소를 넣어서 호출한다. 
		 */
		
		//request.setAttribute("tel", "010-1234-5678");
		//response.sendRedirect("/servletTest/responseRedirectTest.do");
		
		String userName = request.getParameter("username");
		
		// 데이터를 보내려면 GET방식으로 구성해서 보낼 수 있다.
		response.sendRedirect("/servletTest/responseRedirectTest.do?username="
								+ userName + "&tel=010-7777-8888");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
