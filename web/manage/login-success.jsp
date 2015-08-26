<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.busycoder.bean.User" %>
<!DOCTYPE html>
<html>
    <head>
    <title>登录界面</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  </head>
<center>
<body>
    <%
    User user = (User)request.getAttribute("userInfo");
    %>
	<div>Welcom, <%=user.getUserName() %></div>
</body>
</center>
</html>