<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
Class.forName("org.mariadb.jdbc.Driver");
String url = "jdbc:mariadb://localhost:3306/jdbc_test";
Connection conn = DriverManager.getConnection(url,"scott","tiger");
Statement stmt = conn.createStatement();
stmt.executeUpdate("create table test(id varchar(5), pwd varchar(5))");
stmt.close();
conn.close();
%>
ok