<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
	private final int five = 0;
	protected String comboy = "rodeo";
	
	public long addFive(long number){
		return number + 5L;
	}
	
	public class MyInnerClass{
	}
	
	MyInnerClass instanceVariable = new MyInnerClass();
%>
<%
	class WeridClassWithinMethod {
	
	}

	WeridClassWithinMethod weirdClass = new WeridClassWithinMethod();
	
	MyInnerClass innerClass = new MyInnerClass();
	int seven;
	seven = 7;
%>
<%= "Hello, World" %><br />
<%= addFive(12L) %>