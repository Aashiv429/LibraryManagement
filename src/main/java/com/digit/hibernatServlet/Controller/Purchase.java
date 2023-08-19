package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Book;
import com.digit.javaTraining.bean.Plans;
import com.digit.javaTraining.bean.PurchaseHistory;
@WebServlet("/Purchase")
public class Purchase extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Book book = new Book();
		int bid = Integer.parseInt(req.getParameter("bid"));
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("curUser");
        int cost = book.getBookAmount(bid);
        if(cost==-1) {
        	resp.sendRedirect("FailForUser.html");
        }
        else {
        	String bname = book.getBookName(bid);
    		HibernateManager hbm = new HibernateManager();
    		int ranNumber = hbm.generateRandomInvoiceNumber();

    		PurchaseHistory ph = new PurchaseHistory(bid,bname,uid,cost,ranNumber);
    		boolean b = hbm.purchaseBook(bid,uid);
    		if(b==true)
    		{
    			resp.sendRedirect("SuccessForUser.html");
    		}
    		else {
    			resp.sendRedirect("FailForUser.html");
    		}
        }
	}
}