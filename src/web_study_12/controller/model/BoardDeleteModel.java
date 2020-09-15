package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardDeleteModel implements Command {

	private BoardService service = new BoardService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("BoardDeleteModel >> GET");

			int num = Integer.parseInt(request.getParameter("num"));
			int res = service.deleteBoard(new Board(num));
			
			return "boardList.do";
			
		} else {
			System.out.println("BoardDeleteModel >> POST");

			return null;
		}
	}

}
