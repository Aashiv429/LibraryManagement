package com.digit.hibernatServlet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.Book;


@WebServlet("/addBook")
public class addBook extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Book book = new Book();
book.setBid(Integer.parseInt(req.getParameter("bid")));
book.setBname(req.getParameter("bname"));
book.setAuthor(req.getParameter("author"));
book.setCost(Integer.parseInt(req.getParameter("cost")));
book.setCategory(req.getParameter("category"));
		HibernateManager hbm = new HibernateManager();
	boolean x = hbm.saveObj(book);
	if(x==true) {
		PrintWriter print = resp.getWriter();
		resp.sendRedirect("success.html");
	}
		
		
		
	}

}
