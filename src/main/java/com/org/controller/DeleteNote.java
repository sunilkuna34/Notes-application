package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.NotesDao;
import com.org.dao.UserDao;
@WebServlet("/delete")
public class DeleteNote extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		
		
		NotesDao dao=new NotesDao();
		dao.deleteNotesById(id);
		
		HttpSession session=req.getSession();
		session.setAttribute("success", "Deletion succesfully");

		resp.sendRedirect("home.jsp");


	
	}


}
