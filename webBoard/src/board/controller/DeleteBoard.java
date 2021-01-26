package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		System.out.println("board_no : " +board_no);
		
		IBoardService service = BoardServiceImpl.getService();
		
		int res = service.deleteBoard(board_no);
		
		System.out.println("게시글 삭제 결과값  : " + res);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
		
		
		
	}

}
