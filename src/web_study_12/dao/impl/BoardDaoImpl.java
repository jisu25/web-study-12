package web_study_12.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web_study_12.dao.BoardDao;
import web_study_12.ds.JndiDs;
import web_study_12.dto.Board;

public class BoardDaoImpl implements BoardDao {

	private static final BoardDaoImpl instance = new BoardDaoImpl();
	private Connection con;
	
	private BoardDaoImpl() {
	}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	@Override
	public List<Board> selectBoardByAll() {
		String sql = "SELECT * FROM BOARD ORDER BY NUM";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			ArrayList<Board> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getBoard(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Board getBoard(ResultSet rs) throws SQLException {
		int num = rs.getInt("NUM");
		String name = rs.getString("NAME");
		String email = rs.getString("EMAIL");
		String pass = rs.getString("PASS");
		String title = rs.getString("TITLE");
		String content = rs.getString("CONTENT");
		int readCount = rs.getInt("READCOUNT");
		Date writeDate = rs.getTimestamp("WRITEDATE");
		
		return new Board(num, name, email, pass, title, content, readCount, writeDate);
	}

	@Override
	public Board selectBoardByNum(String num) {
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getBoard(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	@Override
	public void updateReadCount(String num) {
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Board checkPassword(String pass, String num) {
		String sql = "SELECT * FROM BOARD WHERE PASS = ? AND NUM = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBoard(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public int insertBoard(Board board) {
		String sql = "INSERT INTO BOARD(NAME, EMAIL, PASS, TITLE, CONTENT) VALUES (?, ?, ?, ?, ?)";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "UPDATE BOARD SET NAME = ?, EMAIL = ?, PASS = ?, TITLE = ?, CONTENT = ? WHERE NUM = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteBoard(Board board) {
		String sql = "DELETE BOARD WHERE NUM = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, board.getNum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
