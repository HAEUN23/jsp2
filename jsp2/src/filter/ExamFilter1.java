package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ExamFilter1 implements Filter{
	private ServletContext context;
	private Map<String, ? extends ServletRegistration> servletMap;
	private 	Map<String, String> user;
	@Override
	public void destroy() {
		System.out.println("destroy1" + this);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = (HttpServletRequest) req;
		String ip = request.getRemoteAddr();
//		if(ip.equals("192.168.0.121")) {
//				RequestDispatcher rd = request.getRequestDispatcher("/common/not_permmision.jsp");
//				rd.forward(req, res);
//		}
		System.out.println(request.getRemoteAddr());
		HttpSession session  = request.getSession();
		if(session.getAttribute("user")==null) {
			user = new HashMap<String, String>();
			user.put("id", "red");
			user.put("pwd", "red");
			user.put("name", "박경훈");
			session.setAttribute("user", user);
		}
		String url = request.getRequestURL().toString();
		String urlPattern = getUrlPatter(url);
		if(urlPattern.equals("jsp")) {
			System.out.println("JSP : " + url);
		}else if(urlPattern.equals("js") || urlPattern.equals("css")){
		}else {
			ServletRegistration s = servletMap.get(urlPattern);
			System.out.println("Servlet:" + s.getClassName());
		}
		fc.doFilter(req, res);
	}

	private String getUrlPatter(String url) {
		int idx = url.lastIndexOf(".");
		if(idx==-1) {
			return "default";
		}
		return url.substring(idx+1);
	}
	@Override
	public void init(FilterConfig fc) throws ServletException {
		context = fc.getServletContext();
		servletMap = context.getServletRegistrations();
		Iterator<String> it = servletMap.keySet().iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			ServletRegistration s = servletMap.get(key);
//		}
//		System.out.println("init1" + fc);
	}
	
}
