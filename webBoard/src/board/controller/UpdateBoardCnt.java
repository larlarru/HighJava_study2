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
 * Servlet implementation class UpdateBoardCnt
 */
@WebServlet("/UpdateBoardCnt.do")
public class UpdateBoardCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		IBoardService service = BoardServiceImpl.getService();
		
		int res = service.updateBoardCnt(board_no);
		System.out.println("게시글 조회수의 res값 : " + res);
		System.out.println("게시글 증가 그리고 res값 : " + res);
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
		
		
	}

}
