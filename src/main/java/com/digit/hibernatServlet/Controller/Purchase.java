package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.PurchaseHistory;
@WebServlet("/Purchase")
public class Purchase extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PurchaseHistory purchase =new PurchaseHistory();
		purchase.setBook_id(Integer.parseInt(req.getParameter("bid")));
		purchase.setBname(req.getParameter("bname"));
		purchase.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		
		HibernateManager hbm = new HibernateManager();
		//session = HibernateManager.session;
		boolean b = hbm.purchase(purchase);
		if(b==true)
		{
			resp.sendRedirect("/Library_Management/DeleteSuccess.html");
		}
		else {
			resp.sendRedirect("/Library_Management/fail.html");
		}
	}
}
