package com.busycoder.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.busycoder.util.VerificationCode;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	VerificationCode vc = new VerificationCode();
    	vc.generateImage();	//生成验证码
    	HttpSession session = request.getSession();
    	session.setMaxInactiveInterval(300); //session有效时间
    	session.setAttribute("verificationCode", vc.getSb().toString());
		response.setContentType("text/html;charset=utf-8");
		OutputStream os = response.getOutputStream();
		ImageIO.write(vc.getImage(),"JPEG", os);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
