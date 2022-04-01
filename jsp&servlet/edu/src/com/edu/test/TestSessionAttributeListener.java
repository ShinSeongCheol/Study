package com.edu.test;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestSessionAttributeListener implements HttpSessionAttributeListener{

	public TestSessionAttributeListener() {
		System.out.println("TestSessionAttributeListner 按眉 积己");
	}

	public void attributeAdded(HttpSessionBindingEvent e) {
		System.out.println("技记 按眉俊 加己 眠啊");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent e) {
		System.out.println("技记 按眉俊 眠啊等  加己 力芭");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent e) {
		System.out.println("技记 按眉俊 眠啊等 加己 措眉");
	}
}
