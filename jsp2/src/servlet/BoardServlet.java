package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Board;
import service.BoardService;
import service.implement.BoardServiceImpl;

public class BoardServlet extends CommonServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson g = new Gson();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		if(command==null) {
			BufferedReader br = request.getReader();
			String jsonStr = "";
			String s = null;
			while((s=br.readLine())!=null) {
				jsonStr += s;
			}
			Map<String, String> pMap = g.fromJson(jsonStr, HashMap.class);
			System.out.println(pMap);
			command = pMap.get("command");
		}
		if(command.equals("list")) {
			List<Board> boardList = bs.selectBoardList();
			String result = g.toJson(boardList);
			doProcess(resp, result);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String command = request.getParameter("command");
		if(command.equals("list")) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_list.jsp");
			List<Board> boardList = bs.selectBoardList();
			request.setAttribute("boardList", boardList);
			rd.forward(request, resp);
		}
	}	
	public void doProcess(HttpServletResponse resp, String writeStr) 
			throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(writeStr);
	}
}
