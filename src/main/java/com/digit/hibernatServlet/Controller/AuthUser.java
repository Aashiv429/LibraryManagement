package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Admin;


@WebServlet("/authUser")
public class AuthUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin ad=new Admin();
		HibernateManager hbm=new HibernateManager();
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		int status=1;
		if(hbm.authUsers(user_id,status)) {
		resp.sendRedirect("SuccessForAdmin.html");	
		}
		else {
			resp.sendRedirect("FailForAdmin.html");	
		}
	}

}
