package com.edu.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener implements ServletContextListener	{
	
	public TestServletContextListener() {
		System.out.println("TestServletContextListener ��ü ����");
	}
	
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("Servlet ��ü �ʱ�ȭ");
	}
	
	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("Servlet ��ü ����");
	}
}
