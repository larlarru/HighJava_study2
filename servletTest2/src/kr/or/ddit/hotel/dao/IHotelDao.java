package kr.or.ddit.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.hotel.vo.HotelVO;

public interface IHotelDao {
	
	// 호텔 지점 가져오는 메서드
	public List<HotelVO>getRoomPl() throws SQLException;
	
	// 방타입 가져오는 메서드
	public List<HotelVO>getRoomType(String room_type) throws SQLException;
	
}
