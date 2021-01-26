package board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;


/**
 * Servlet implementation class BoardList
 */
@WebServlet("/getBoardAllList.do")
public class GetBoardAllList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 전체 게시글 가져오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IBoardService service = BoardServiceImpl.getService();
		
		List<BoardVO> list = service.getBoardListAll();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("board/getboardAllList.jsp").forward(request, response);
		
	}
	
	// 검색해서 조회된 게시글 가져오기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String board_title = request.getParameter("board_title");
			
			
			IBoardService service = BoardServiceImpl.getService();
				
			List<BoardVO> list = service.searchBoardListAll(board_title);
			
			System.out.println("list 사이즈 크기" + list.size());
			if(list.size()==0) list = null;
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("board/getboardAllList.jsp").forward(request, response);
		
	}

}
