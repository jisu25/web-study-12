package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardCheckPassModel implements Command {

	private BoardService service = new BoardService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("BoardCheckPass.do >> GET");
			
			String url = null;
			
			String num = request.getParameter("num");
			String pass = request.getParameter("pass");
			
			System.out.println("num : " + num + ", pass : " + pass);
			Board board = service.checkPassword(pass, num);
			
			if(board != null) {
				url = "board/checkSuccess.jsp";
			} else {
				url = "board/boardCheckPass.jsp";
				request.setAttribute("message", "비밀번호가 틀렸습니다.");
			}
			
			return url;
			
		} else {
			
			
		}
		return null;
	}

}
