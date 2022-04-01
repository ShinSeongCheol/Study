package com.edu.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter{
	
	String charset;

	@Override
	public void destroy() {
		System.out.println("destroy() 호출 ......... two");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter() 호출 전 ......... two");
		req.setCharacterEncoding(charset);
		chain.doFilter(req, resp);
		System.out.println("doFilter() 호출 후 ......... two");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init() 호출 ......... two");
		charset = filterConfig.getInitParameter("en");
	}

}
