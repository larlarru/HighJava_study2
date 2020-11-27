package kr.or.ddit.reqres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest01
 */
@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * - forward
		 * 		특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		 * 		(이때 파라미터를 넘겨 줄 수 있다.)
		 * 
		 * 		다른 서블릿이나 JSP로 제어가 넘어갈 때 URL 주소는 변하지 않는다.
		 * 		그래서 클라이언트에게 페이지 주소를 숨길 때 사용할 수 있으며,
		 * 		redirect보다 성능이 좋다.
		 * 		(웹 애플리케이션 내부에서만 접근이 가능하다.)
		 */
		
		// 이동되는 페이지로 원하는 '데이터'를 넘길려면 request객체의
		// setAttribute()메서드를 이용하여 데이터를 셋팅하고
		// 받는 쪽에서는 request객체의 getAttribute()메서드로 읽어온다.
		
		// forwarding 작업 순서
		
		// 1. 전달할 데이터가 있으면 setAttribute()메서드로 셋팅한다.
		request.setAttribute("tel", "010-1234-5678");
		
		// 2. RequestDispatcher객체를 생성한다.
		//		==> 이때 이동할 페이지를 지정한다.
		RequestDispatcher rd = 
				request.getRequestDispatcher("/requestForwardTest.do");
		
		// 3. Requestdispatcher객체의 forward()메서드를 호출한다.
		//		==> 이때 HttpServletRequest객체와 
		//			HttpServletResponse객체를 매개값으로 넘겨준다.
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
