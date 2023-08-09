package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;



@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int bid = (Integer.parseInt(req.getParameter("bid")));


        HibernateManager hbm = new HibernateManager();

        hbm.removeBook(bid);

        res.sendRedirect("DeleteSuccess.html");
    }
}
