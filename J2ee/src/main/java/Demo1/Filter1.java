package Demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter("/UserServlet")
public class Filter1  implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	PrintWriter pr=response.getWriter();
	pr.print("Hello..., Filter1");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
