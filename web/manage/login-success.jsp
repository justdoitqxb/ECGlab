<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>登录界面</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  </head>
<center>
<body>
    <%
    String username = request.getParameter("username");
    %>
	<div>Welcom, <%=username %></div>
</body>
</center>
</html>