package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;


public interface IBoardService {
	
	// 전체 게시글 가져오기
	public List<BoardVO> getBoardListAll();
	
	// 게시글 등록
	public int insertBoard(BoardVO vo);
	
	// 게시글 수정
	public int updateBoard(BoardVO vo);
	
	// 게시글 삭제
	public int deleteBoard(int board_no);
	
	// 검색한 게시글 조회해서 가져오기
	public List<BoardVO> searchBoardListAll(String board_title);
	
	// 게시글 조회수 증가
	public int updateBoardCnt(int board_no);
	
}
