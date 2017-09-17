package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExamFilter2 implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy2" + this);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("doFilter2" + fc);
		fc.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("init2" + fc);
	}
	
}
