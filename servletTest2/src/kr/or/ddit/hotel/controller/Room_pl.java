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
 * Servlet implementation class Room_pl
 */
@WebServlet("/Room_pl.do")
public class Room_pl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IHotelService service = HotelServiceImpl.getInstance();
		
		List<HotelVO> list = service.getRoomPl();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("hotel/listRoomPl.jsp").forward(request, response);
		
	}

}


