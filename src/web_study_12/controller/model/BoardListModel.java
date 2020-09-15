package web_study_12.controller.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

//@WebServlet("/boardList.do")
public class BoardListModel implements Command {

	private BoardService service = new BoardService();
	
	 @Override
	 public String process(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		 
		 if(request.getMethod().equalsIgnoreCase("GET")) {
			 System.out.println("BoardListModel >> GET");
			 
			 return "board/boardList.jsp";
		 } else {
			 System.out.println("BoardListModel >> POST");
			 
		     List<Board> list = service.getBoards();
	//	     request.setAttribute("list", list);
		     
		     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd k:mm:ss a").create();
		     String jsonList = gson.toJson(list, new TypeToken<List<Board>>() {}.getType());
		     System.out.println(jsonList);
		     
		     response.setCharacterEncoding("UTF-8");
		     response.setContentType("Application/json");
		     response.getWriter().print(jsonList);
		     
		     return null;
		 }
	 }
}
