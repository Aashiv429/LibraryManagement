package com.digit.hibernatServlet.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Bank;
import com.digit.javaTraining.bean.Plans;
import com.digit.javaTraining.bean.Subscription;

@WebServlet("/subcription")
public class subscription extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int sid = Integer.parseInt(req.getParameter("sid"));
		int bid = Integer.parseInt(req.getParameter("bid"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		Plans plan = new Plans();
		int amount = plan.Amount(sid);
		if (amount == -1) {
			resp.sendRedirect("FailForUser.html");
		} else {
			HttpSession session = req.getSession();
			int curUser = (int) session.getAttribute("curUser");

			Bank b = new Bank();
			b.view(bid);
			int balance = b.getAmount();
			
			HibernateManager hbm = new HibernateManager();
			boolean blogin = hbm.Banklogin(bid, pin);
			
			if(blogin==true && balance>=amount) {
				int ranNumber = hbm.generateRandomInvoiceNumber();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDateTime now = LocalDateTime.now();
				String date = dtf.format(now);
				Subscription sub = new Subscription(sid, curUser, amount, ranNumber, date);
				boolean x = hbm.saveObj(sub);
				if (x == true) {
					hbm.updateAmount(bid, balance-amount);
					resp.sendRedirect("SuccessForUser.html");
				} else {
					resp.sendRedirect("FailForUser.html");
				}
			}
			else {
				resp.sendRedirect("FailForUser.html");
			}

		}

	}

}
