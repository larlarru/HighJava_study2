package kr.or.ddit.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.hotel.service.HotelServiceImpl;
import kr.or.ddit.hotel.service.IHotelService;
import kr.or.ddit.hotel.vo.HotelVO;

/**
 * Servlet implementation class Room_type
 */
@WebServlet("/Room_type.do")
public class Room_type extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String roomType = request.getParameter("room_type");
		
		IHotelService service = HotelServiceImpl.getInstance();
		
		List<HotelVO> list = service.getRoomType(roomType);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("hotel/listRoomType.jsp").forward(request, response);
		
	}

}
