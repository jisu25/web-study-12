package web_study_12.dao;

import java.sql.Connection;
import java.util.List;

import web_study_12.dto.Board;

public interface BoardDao {
	List<Board> selectBoardByAll();
	Board selectBoardByNum(String num);
	
	void updateReadCount(String num);
	Board checkPassword(String pass, String num);
	
	int insertBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(Board board);
	
	void setCon(Connection con);
}
