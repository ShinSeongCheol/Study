package com.edu.test;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestSessionAttributeListener implements HttpSessionAttributeListener{

	public TestSessionAttributeListener() {
		System.out.println("TestSessionAttributeListner ��ü ����");
	}

	public void attributeAdded(HttpSessionBindingEvent e) {
		System.out.println("���� ��ü�� �Ӽ� �߰�");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent e) {
		System.out.println("���� ��ü�� �߰���  �Ӽ� ����");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent e) {
		System.out.println("���� ��ü�� �߰��� �Ӽ� ��ü");
	}
}
