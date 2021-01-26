package board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;
import ibatis.config.SqlMapClientFactory;



/*
 * SqlMapClient객체 얻어오기
 * 자신의 객체를 생성해서 리턴하기
 */

public class BoardDaoImpl implements IBoardDao{
	
	private SqlMapClient client;
	
	private static IBoardDao dao;
	
	private BoardDaoImpl() {
		
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBoardDao getDao() {
		
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	// 게시판 가져오기
	@Override
	public List<BoardVO> getBoardListAll() throws SQLException {
		return client.queryForList("board.boardListAll");
	}
	
	// 게시글 등록
	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		 String result = (String) client.insert("board.insertBoard", vo);
		 int res = 0;
		 if(result==null) res = 1;
		return res;
	}
	
	// 게시글 삭제
	@Override
	public int deleteBoard(int board_no) throws SQLException {
		return client.delete("board.deleteBoard", board_no);
	}
	
	// 게시글 수정
	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		return client.update("board.updateBoard", vo);
	}
	
	// 검색해서 조회된 게시글 가져오기
	@Override
	public List<BoardVO> searchBoardListAll(String board_title) throws SQLException {
		return (List<BoardVO>) client.queryForList("board.searchBoardListAll", board_title);
	}
	
	// 게시글 조회수 올리기
	@Override
	public int updateBoardCnt(int board_no) throws SQLException {
		return client.update("board.updateBoardCnt", board_no);
	}
	
	
	
	
	

	
	

}
