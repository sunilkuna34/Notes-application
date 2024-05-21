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
@WebServlet("/ViewNotes")
public class viewingnote extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title=req.getParameter("title");
		String description = req.getParameter("description");		
		
		User user=new User();
		user.setId(user.getId());
				
		
		UserDao dao=new UserDao();
		dao.fetchUserById(user.getId());
		
		HttpSession session=req.getSession();
		session.setAttribute("update", "updated succesfully");
		resp.sendRedirect("home.jsp");

	}
	
}
