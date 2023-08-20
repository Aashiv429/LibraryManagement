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
import com.digit.javaTraining.bean.Bank;
import com.digit.javaTraining.bean.Book;
import com.digit.javaTraining.bean.Plans;
import com.digit.javaTraining.bean.PurchaseHistory;
@WebServlet("/Purchase")
public class Purchase extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		int bid = Integer.parseInt(req.getParameter("bid"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		Book book = new Book();
		HibernateManager hbm = new HibernateManager();
        int cost = book.getBookAmount(bookid);
        if(cost==-1) {
        	resp.sendRedirect("FailForUser.html");
        }
        else {
        	HttpSession session = req.getSession();
    		int uid = (int) session.getAttribute("curUser");
    		
    		Bank b = new Bank();
			b.view(bid);
			int balance = b.getAmount();
    		
    		boolean blogin = hbm.Banklogin(bid, pin);
    		
    		if(blogin==true && balance>=cost) {
    			String bname = book.getBookName(bookid);
        		int ranNumber = HibernateManager.generateRandomInvoiceNumber();
        		PurchaseHistory ph = new PurchaseHistory(bookid,bname,uid,cost,ranNumber);
				boolean b1 = hbm.saveObj(ph);
        		if(b1==true) {
        			hbm.updateAmount(bid, balance-cost);
        			resp.sendRedirect("SuccessForUser.html");
        		}
        		else {
        			resp.sendRedirect("FailForUser.html");
        		}
    		}
    		else {
    			resp.sendRedirect("FailForUser.html");
    		}	
        }
	}
}