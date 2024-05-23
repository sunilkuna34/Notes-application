package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/changepassword")
public class changepassword1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao=new UserDao();
		HttpSession session=req.getSession();
		int userId=(Integer)session.getAttribute("userId");
		User user=dao.fetchUserById(userId);
		String userpwd=user.getPassword();
		int id=Integer.parseInt(req.getParameter("id"));
		String oldpwd=req.getParameter("password");
		String pwd1=req.getParameter("password1");
		String pwd2=req.getParameter("password2");
		
		if(userpwd.equals(oldpwd) && pwd1.equals(pwd2)) {
			
			dao.changePwdById(id,pwd1);
			session.setAttribute("success", "pwd succesfully change");

			resp.sendRedirect("home.jsp");

		}
		else {
			session.setAttribute("fail", "Enter correctly");
			
			resp.sendRedirect("changepassword.jsp");
		}

	}

}
