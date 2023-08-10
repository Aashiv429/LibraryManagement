package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.User;


@WebServlet("/ulogin")
public class UserLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u= new User();
		HibernateManager hm= new HibernateManager();
		u.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		u.setPwd(req.getParameter("pwd"));
		
		System.out.println(u.getUser_id());
		
		boolean b= hm.userLogin(u.getUser_id());
	
		
		if(b==true) {
			resp.sendRedirect("userHome.html");
		}
		else {
			resp.sendRedirect("fail.html");
			System.out.println("login failed");
		}
	}

}
