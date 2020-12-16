package kr.or.ddit.hotel.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.hotel.dao.IHotelDao;
import kr.or.ddit.hotel.vo.HotelVO;

public class HotelServiceImpl implements IHotelService{
	
	private IHotelDao dao;
	private static HotelServiceImpl service;
	
	public static HotelServiceImpl getInstance() {
		if(service==null) service = new HotelServiceImpl();
		return service;
	}

	@Override
	public List<HotelVO> getRoomPl() {

		List<HotelVO> list = null;
		
		try {
			list = dao.getRoomPl();
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<HotelVO> getRoomType(String room_type) {
		
		List<HotelVO> list = null;
		
		try {
			list = dao.getRoomType(room_type);
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		
		return list;
	}

}
