package filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ExamFilter1 implements Filter{
	private ServletContext context;
	private Map<String, ? extends ServletRegistration> servletMap;
	@Override
	public void destroy() {
		System.out.println("destroy1" + this);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println("doFilter1" + fc);
		System.out.println(request.getRequestURL().toString());
		fc.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		context = fc.getServletContext();
		servletMap = context.getServletRegistrations();
		Iterator<String> it = servletMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			ServletRegistration s = servletMap.get(key);
			System.out.println(s.getClassName());
		}
		System.out.println("init1" + fc);
	}
	
}
