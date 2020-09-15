package web_study_12.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.ds.JdbcUtil;
import web_study_12.dto.Board;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoImplTest {

	private static BoardDaoImpl dao;
	private static Connection con;

	@BeforeClass
	public static void setUpBeforClass() throws Exception {
		con = JdbcUtil.getConnection(); 
		dao = BoardDaoImpl.getInstance();
		dao.setCon(con);
	}
	
	
	@Test
	public void test06SelectBoardByAll() {
		System.out.println("SelectBoardByAll()");
		List<Board> list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test07SelectBoardByNum() {
		System.out.println("SelectBoardByAll()");
		Board board = dao.selectBoardByNum("3");
		Assert.assertNotNull(board);
		System.out.println(board);
	}

	@Test
	public void test04UpdateReadCount() {
		System.out.println("UpdateReadCount");
		dao.updateReadCount("3");
	}

	@Test
	public void test05CheckPassword() {
		System.out.println("CheckPasswor()");
		Board board = dao.checkPassword("1234", "2");
		Assert.assertNotNull(board);
		System.out.println(board);
	}

	@Test
	public void test01InsertBoard() {
		System.out.println("InsertBoard()");
		int res = dao.insertBoard(new Board(0, "이지수", "aaa@gmail.com", "1212", "ㅎㅇㅎㅇ", "test", 0, null));
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateBoard() {
		System.out.println("UpdateBoard()");
		int res = dao.updateBoard(new Board(7, "이지수", "aaa@gmail.com", "1212", "ㅎㅇㅎㅇㅎㅇ", "test", 0, null));
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03DeleteBoard() {
		System.out.println("DeleteBoard()");
		int res = dao.deleteBoard(new Board(7));
		Assert.assertEquals(1, res);
	}

}
