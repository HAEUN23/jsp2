package service;

import java.util.List;
import java.util.Map;

import dto.Board;
import dto.Page;

public interface BoardService {
	List<Board> selectBoardList(Map<String, String> pHm, Page p);
	Map<String, String> selectBoard();
	int insertBoard();
	int updateBoard();
	int deleteBoard();
}
