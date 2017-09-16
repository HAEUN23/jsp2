package servlet;

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
import dto.Page;
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
		
		String param = request.getParameter("param");
		String page = request.getParameter("page");
		Map<String, String> pMap = g.fromJson(param, HashMap.class);
		Page p = g.fromJson(page, Page.class);
		System.out.println(pMap);
		String command = pMap.get("command");
		String content = pMap.get("content");
		String result= "";
		Map<String, Object> map = new HashMap<String, Object>();
		if(command.equals("list")) {
			if(content!=null && content.trim().length()<=1) {
				map.put("error", "한글자로 검색하지 말라고!!");
				result = g.toJson(map);
			}else {
				List<Board> boardList = bs.selectBoardList(pMap,p);
				map.put("list", boardList);
				map.put("page", p);
				map.put("param", pMap);
				result = g.toJson(map);
			}
		}
		doProcess(resp, result);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String command = request.getParameter("command");
		if(command.equals("list")) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_list.jsp");
			List<Board> boardList = bs.selectBoardList(null,null);
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
