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
@WebServlet("/InsertBoard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String board_title = request.getParameter("board_title");
		String board_writer = request.getParameter("board_writer");
		String board_content = request.getParameter("board_content");
		
		System.out.println("board_title : " +board_title);
		System.out.println("board_writer : " + board_writer);
		System.out.println("board_content : " + board_content);
		
		BoardVO vo = new BoardVO();
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);
		
		System.out.println("vo.getBoard_title() : " +vo.getBoard_title());
		System.out.println("vo.getBoard_writer() : " + vo.getBoard_writer());
		System.out.println("vo.getBoard_content() : " + vo.getBoard_content());
		
		IBoardService service = BoardServiceImpl.getService();
		
		int res = service.insertBoard(vo);
		
		System.out.println("게시글 등록 결과값  : " + res);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
		
		
		
	}

}
