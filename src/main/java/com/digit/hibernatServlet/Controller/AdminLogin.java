package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Admin;

@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin a = new Admin();
		HibernateManager hm = new HibernateManager();
		int admin_id = Integer.parseInt(req.getParameter("admin_id"));
	int secret_pin =	Integer.parseInt(req.getParameter("secret_pin"));

		System.out.println(a.getAdmin_id());

		boolean b = hm.Adminlogin(admin_id, secret_pin);

		if (b == true) {
			resp.sendRedirect("adminHome.html");
		} else {
			resp.sendRedirect("fail.html");
		}
	}

}
