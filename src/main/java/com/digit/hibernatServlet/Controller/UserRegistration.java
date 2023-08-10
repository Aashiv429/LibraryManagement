package com.digit.hibernatServlet.Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.User;


@WebServlet("/Register")
public class UserRegistration extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user =  new User();
		user.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		user.setUname(req.getParameter("uname"));
		user.setPwd(req.getParameter("pwd"));
		user.setPhone(Integer.parseInt(req.getParameter("phone")));
		user.setEmail(req.getParameter("email"));
//		user.setStatus(Integer.parseInt(req.getParameter("status")));
		HibernateManager hbm = new HibernateManager();
	boolean x = hbm.saveObj(user);
	if(x==true) {
		PrintWriter print = resp.getWriter();
		resp.sendRedirect("success.html");
	}
		
		
		
	}

}
