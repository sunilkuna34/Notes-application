package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;

@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		
		
		UserDao dao=new UserDao();
		dao.deleteUserById(id);
		
		
		HttpSession session=req.getSession();
		resp.sendRedirect("home.jsp");


	
	}


}
