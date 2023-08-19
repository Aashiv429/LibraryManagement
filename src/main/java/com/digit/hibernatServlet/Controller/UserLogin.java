package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.javaTraining.bean.User;


@WebServlet("/ulogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u= new User();
		HibernateManager hm= new HibernateManager();
		int uid = Integer.parseInt(req.getParameter("user_id"));
		String pwd = req.getParameter("pwd");
		boolean b= hm.userLogin(uid,pwd);
		HttpSession session = req.getSession(true);
		if(b==true) {
			session.setAttribute("curUser", uid);
			resp.sendRedirect("userHome.html");
		}
		else {
			resp.sendRedirect("fail.html");
		}
	}

}
