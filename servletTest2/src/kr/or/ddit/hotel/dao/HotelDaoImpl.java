package kr.or.ddit.hotel.dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hotel.vo.HotelVO;
import kr.or.ddit.util.BuildSqlMapClient;

public class HotelDaoImpl implements IHotelDao{
	
	private SqlMapClient smc; 
	
	private static HotelDaoImpl dao;
	
	private HotelDaoImpl() {
		
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static HotelDaoImpl getInstance() {
		if(dao==null) dao = new HotelDaoImpl();
		return dao;
	}
	
	@Override
	public List<HotelVO> getRoomPl() throws SQLException {
		
	/*	List<HotelVO> list = null;
		
		try {
			list = smc.queryForList("hotel.getRoomPl");
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		*/
		return smc.queryForList("hotel.getRoomPl");
	}

	@Override
	public List<HotelVO> getRoomType(String room_type) throws SQLException {
		/*
		List<HotelVO> list = null;
		
		try {
			list = smc.queryForList("hotel.getRoomType", room_type);
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		*/
		return smc.queryForList("hotel.getRoomType", room_type);
	}

}
