<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.busycoder.dao.*"%>
<%@page import="com.busycoder.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserDao ud = new UserDao();
User user = ud.login("qxb", "123456");
%>
<li>username : <%=user.getUserName() %></li>
<li>password : <%=user.getPassword() %></li>
<img id="verification_code" src="vc">
</body>
</html>