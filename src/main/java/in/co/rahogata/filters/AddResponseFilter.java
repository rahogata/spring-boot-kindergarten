package in.co.rahogata.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AddResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	        httpServletResponse.setHeader(
	                "Alt-Svc", "h3=\":" + request.getLocalPort() + "\"; ma=86400; persist=1");
	        chain.doFilter(request, response);
	}

}
