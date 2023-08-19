package com.digit.hibernatServlet.Controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;



@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int user_id = (Integer.parseInt(req.getParameter("user_id")));


        HibernateManager hbm = new HibernateManager();

        boolean b = hbm.removeUser(user_id);

        if(b==true) {
        	res.sendRedirect("SuccessForAdmin.html");
        }
        else {
        	res.sendRedirect("FailForAdmin.html");
        }
    }
}

