package com.digit.hibernatServlet.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Subscription;



@WebServlet("/viewSpecific")
public class ViewSubscriptions extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		Subscription s = new Subscription();
		 HibernateManager hbm = new HibernateManager();
		ArrayList<Subscription> ss = hbm.readAll();
		HttpSession session = req.getSession();
		session.setAttribute("Allss", ss);
		resp.sendRedirect("/Library_Management/ViewP.jsp");
	}
}