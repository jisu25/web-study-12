package web_study_12.service;

import java.sql.Connection;
import java.util.List;

import web_study_12.dao.BoardDao;
import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.ds.JndiDs;
import web_study_12.dto.Board;

public class BoardService {

	private BoardDao dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();

	public BoardService() {
		dao.setCon(con);
	}
	
	public List<Board> getBoards() {
		return dao.selectBoardByAll();
	}
	
	public Board getBoard(String num) {
		return dao.selectBoardByNum(num);
	}
	
	public int addBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public int modifyBoard(Board board) {
		return dao.updateBoard(board);
	}
	
	public int deleteBoard(Board board) {
		return dao.deleteBoard(board);
	}
	
	public void updateReadCount(String num) {
		dao.updateReadCount(num);
	}
	
	public Board checkPassword(String pass, String num) {
		return dao.checkPassword(pass, num);
	}
	
}
