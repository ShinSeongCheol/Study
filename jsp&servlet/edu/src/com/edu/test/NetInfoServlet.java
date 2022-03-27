package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request ���� ��� Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>��Ʈ��ũ ���� ��û ����</h3>");
		out.print("Requset Scheme : " + req.getScheme() + "<br/>");
		out.print("Server Name : " + req.getServerName() + "<br/>");
		out.print("ServerAddress : " + req.getLocalAddr() + "<br/>");
		out.print("Server Port : " + req.getLocalPort() + "<br/>");
		out.print("Clinet Address : " + req.getRemoteAddr() + "<br/>");
		out.print("Client Host : " + req.getRemoteHost() + "<br/>");
		out.print("Client Port : " + req.getRemotePort() + "<br/>");
		out.print("</body></html>");
		out.close();
	}
}
