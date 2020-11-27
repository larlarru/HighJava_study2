package kr.or.ddit.reqres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cal
 */
@WebServlet("/cal.do")
public class Cal extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String[] calType = request.getParameterValues("calType");
		double res = 0;
		boolean calcOk = true;	// 계산 성공 여부를 저장할 변수 (false면 계산 불능상태)
		
		if(calType[0].equals("+")) {
			res = num1 + num2;
		} else if(calType[0].equals("-")) {
			res = num1 - num2;
		} else if(calType[0].equals("*")) {
			res = num1 * num2;
		} else if(calType[0].equals("/")) {
			if(num2==0) {
				calcOk = false;
			} else {
				res = (double) num1 / num2;
			}
		} else if(calType[0].equals("%")) {
			res = num1 % num2;
		}
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>계산 결과</title></head>");
		out.println("<body>");
		out.println("<h2>계산 결과</h2>");
		out.println("num1 : " + num1 + "<br>");
		out.println("num2 : " + num2 + "<br>");
		out.print("계산 타입 : " + calType[0] + "<br>");
		out.println("합 : " + res + "<br>");
		//out.println(num1 + " " + calType[0] + " " + num2 + " = " + res + "<br>");
		out.println(num1 + " " + calType[0] + " " + num2 + " = ");
		if(calcOk==true) {
			out.println(res + "<br>");
		} else {
			out.println("계산 불능(0으로 나눠서)<br>");
		}
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












