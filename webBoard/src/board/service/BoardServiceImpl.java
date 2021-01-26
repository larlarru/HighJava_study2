package board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;


public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService() {
		if(service==null) service = new BoardServiceImpl();
		
		return service;
	}
	
	// 게시글 전체 가져오기
	@Override
	public List<BoardVO> getBoardListAll() {
		
		List<BoardVO> list = null;
		
		try {
			list = dao.getBoardListAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 게시글 등록
	@Override
	public int insertBoard(BoardVO vo) {
		
		int res = 0;
		
		try {
			res = dao.insertBoard(vo);
		} catch (SQLException e) {
			res = 0;
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 게시글 삭제
	@Override
	public int deleteBoard(int board_no) {
		
		int res = 0;
		
		try {
			res = dao.deleteBoard(board_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 게시글 내용 수정
	@Override
	public int updateBoard(BoardVO vo) {
		int res = 0;
		
		try {
			res = dao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 검색해서 조회된 게시글 가져오기
	@Override
	public List<BoardVO> searchBoardListAll(String board_title) {
		List<BoardVO> list = null;
		
		try {
			list = (List<BoardVO>) dao.searchBoardListAll(board_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 게시글 조회수 증가
	@Override
	public int updateBoardCnt(int board_no) {
		int res = 0;
		
		try {
			res = dao.updateBoardCnt(board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	
	

}
