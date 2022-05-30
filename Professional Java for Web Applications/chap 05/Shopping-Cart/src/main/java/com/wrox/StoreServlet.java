package com.wrox;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "storeServlet",
		urlPatterns = "/shop"
)
public class StoreServlet extends HttpServlet{
	private final Map<Integer, String> products = new Hashtable<>();
	
	public StoreServlet() {
		this.products.put(1, "Sandpaper");
		this.products.put(2, "Nails");
		this.products.put(3, "Glue");
		this.products.put(4, "Paint");
		this.products.put(5, "Tape");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null)
			action = "browse";
		
		
	}
}
