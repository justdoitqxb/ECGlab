<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.busycoder.dao.*"%>
<%@page import="com.busycoder.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<form action="/manage/login.jsp" name="form1" method="post" onsubmit="return checkForm(this);">
        <table align=center>
		<tr>
		<td>用户账号</td>
		<td><input type=text style="width:150px" name="username"></td>
		</tr>
                <tr>
		<td>用户密码</td>
		<td><input type=password style="width:150px" name="password"></td>
		</tr>
		<tr>
		<td colspan=2 align=center>
		<input type=submit value=登录>
		<input type=reset value=清空></td>
		</tr>
	</table>
       </form>
</body>
</html>