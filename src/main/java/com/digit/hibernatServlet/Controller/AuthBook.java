package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Admin;


@WebServlet("/authBook")
public class AuthBook extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin ad=new Admin();
		HibernateManager hbm=new HibernateManager();
        //int status=Integer.parseInt(req.getParameter("status"));
		int bid=Integer.parseInt(req.getParameter("bid"));
		int status=1;
		if(hbm.authoriseBook(bid,status)) {
		resp.sendRedirect("success.html");	
		}
		else {
			resp.sendRedirect("fail.html");	
		}
	}

}
