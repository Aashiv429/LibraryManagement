package com.digit.hibernatServlet.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.bean.Plans;



@WebServlet("/ViewPlan")
public class ViewPlans extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		Plans p = new Plans();
		ArrayList<Plans> ss = p.readAll();
		HttpSession session = req.getSession();
		session.setAttribute("Allplans", ss);
		resp.sendRedirect("/Library_Management/ViewP.jsp");
	}
}
