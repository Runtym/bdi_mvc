package com.board.bdi;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
	private String excludeUris;

    public AuthFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		System.out.println(uri);
		HttpSession hs = req.getSession(); 
		if(hs.getAttribute("user")==null && !uri.matches(excludeUris)) {
			if(uri.indexOf("userLogin")==-1 && uri.indexOf("userJoin")==-1) {
				HttpServletResponse res = (HttpServletResponse)response;
				res.sendRedirect("/views/user/userLogin");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		excludeUris = fConfig.getInitParameter("excludeUris");
	}

}
