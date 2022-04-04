<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
Class.forName("org.mariadb.jdbc.Driver");
String url = "jdbc:mariadb://localhost:3306/jdbc_test";
Connection conn = DriverManager.getConnection(url,"scott","tiger");
Statement stmt = conn.createStatement();
//stmt.executeUpdate("create table test(id varchar(5), pwd varchar(5))");
/*stmt.executeUpdate("insert into test values('aa','11')");
stmt.executeUpdate("insert into test values('bb','22')");
stmt.executeUpdate("insert into test values('cc','33')");*/
//ResultSet rs = stmt.executeQuery("select * from test");

String id = request.getParameter("id");
String password = request.getParameter("pwd");

PreparedStatement pstmt = conn.prepareStatement("insert into test values(?,?)");
pstmt.setString(1, id);
pstmt.setString(2, password);
pstmt.executeQuery();

ResultSet rs = stmt.executeQuery("select * from test");

while(rs.next()){
	out.print("<br>" + rs.getString("id") + ":" + rs.getString(2));
}

rs.close();

stmt.close();
conn.close();
%>
ok