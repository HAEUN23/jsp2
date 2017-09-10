package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

public class ExamServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
	}	
	
	public static void main(String[] args) {
		ExamServlet hs = new ExamServlet();
		try {
			HttpServletRequestWrapper hsr = new HttpServletRequestWrapper(null);
			HttpServletResponseWrapper hsre = new HttpServletResponseWrapper(null);
			HttpSessionBindingEvent hse = new HttpSessionBindingEvent(null, null);
			
			HttpSession session = hsr.getSession();
			hs.doGet(hsr, hsre);
		} catch (ServletException | IOException e ) {
			e.printStackTrace();
		}
	}
}
