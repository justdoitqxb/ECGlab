<%@page import="com.busycoder.bean.User"%>
<%@page import="com.busycoder.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("gbk");
         String userName = request.getParameter("username");
         String password = request.getParameter("password");
         UserDao dao=new UserDao();
         User user = dao.login(userName, password);
             if(user == null){
                 request.setAttribute("errorMessage","登录失败，帐号或者密码有误!");
                 request.getRequestDispatcher("/manage/login-error.jsp").forward(request,response);
                  }
             else{
                 session.setAttribute("username", user.getUserName());                                
                 request.getRequestDispatcher("/manage/login-success.jsp").forward(request,response);
                  }
%>
