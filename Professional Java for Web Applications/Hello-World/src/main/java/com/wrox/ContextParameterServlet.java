package com.wrox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "contextParameterServet",
		urlPatterns = {"/contextParameters"}
		)

public class ContextParameterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c = this.getServletContext();
		PrintWriter writer = response.getWriter();
		
		writer.append("setting One: ").append(c.getInitParameter("settingOne"))
		.append("setting Two: ").append(c.getInitParameter("settingTwo"));
	}
}
