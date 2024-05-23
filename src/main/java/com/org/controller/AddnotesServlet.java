package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;
@WebServlet("/add_notes")
public class AddnotesServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		Notes notes=new Notes();
		notes.setTitle(title);
		notes.setDescription(description);
		UserDao dao=new UserDao();
		HttpSession session = req.getSession();
		int id = (Integer)session.getAttribute("userId");
		User user=dao.fetchUserById(id);
		
	List<Notes> list	=new ArrayList<>();
	list.add(notes);
	user.setNotesList(list);
	notes.setUser(user);
	
	
	dao.SaveAndUpdateUser(user);
	session.setAttribute("success", "Notes added succesfully");
	resp.sendRedirect("home.jsp");
	
	
	
	
	}

}
