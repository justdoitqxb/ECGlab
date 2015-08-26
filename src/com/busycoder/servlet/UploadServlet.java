package com.busycoder.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpleadServlet
 */
@WebServlet("/UpleadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		response.setContentType("text/html;charset=UTF-8");
   		PrintWriter out = response.getWriter();
   		Locale  locale = request.getLocale();
   		ResourceBundle bundle = ResourceBundle.getBundle("application", locale);
   		String welcome = bundle.getString("welcome");
   		out.println(java.net.URLDecoder.decode(MessageFormat.format(welcome, "qxb"),"UTF-8"));
   		InputStream is = request.getInputStream();
   		InputStreamReader isr = new InputStreamReader(is);
   		BufferedReader br = new BufferedReader(isr);
   		String requestData = "";
   		String str = "";
   		while((str=br.readLine())!=null){
   			requestData += str;    		
   		}
   		requestData = java.net.URLDecoder.decode(requestData, "UTF-8");
   		out.println();
   		out.println("test"+requestData);
    }
}
