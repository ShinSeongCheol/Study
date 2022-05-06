package com.edu.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TestSessionListener implements HttpSessionListener{

	public TestSessionListener() {
		System.out.println("TestSessionListener ��ü ����");
	}
	
	public void sessionCreated(HttpSessionEvent e) {
		System.out.println("���� ��ü ����");
	}
	
	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println("���� ��ü ����");
	}
}