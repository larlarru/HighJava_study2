package kr.or.ddit.hotel.service;

import java.util.List;

import kr.or.ddit.hotel.vo.HotelVO;

public interface IHotelService {
	
	// 호텔 지점 가져오는 메서드
	public List<HotelVO>getRoomPl();
	
	// 방타입 가져오는 메서드
	public List<HotelVO>getRoomType(String room_type);
	
}
