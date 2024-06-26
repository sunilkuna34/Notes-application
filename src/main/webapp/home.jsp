<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>

</head>
<body>
<%
int userId=(Integer)session.getAttribute("userId");
UserDao dao=new UserDao();
User user=dao.fetchUserById(userId);
if(user ==null){
	response.sendRedirect("login.jsp");
}else{
%>
<%@ include file="components/homenavbar.jsp" %>

<h1 style="text-align: center;">Welcome to Homepage</h1>
<%
						String msg=(String)session.getAttribute("success"); 
						if(msg!=null){
						%>
							<p class="text-center fs-4"> <%=msg%></p>
						<% 
						
						session.removeAttribute("success");
						}
						%>
						
						<%
						String msg1=(String)session.getAttribute("update"); 
						if(msg1!=null){
						%>
							<p class="text-center fs-4"> <%=msg1%></p>
						<% 
						
						session.removeAttribute("update");
						}
						%>
						
						
						<%
						
						List<Notes> list=user.getNotesList();
						
						%>

<div class="container" border>
<div>
<a href="add-note.jsp" class="btn bg-primary text-white ">Add Notes</a>
</div>
<div class="row">
<% 
for(Notes n:list){
	%>
<div class="col-md-4 card border border-primary m-4" style="width: 15rem">
	<div class="card-body">
	<div class="d-flex flex-wrap justify-content-evenly">
	<div>
	<h2 class="text-success card-title"><%=n.getTitle() %></h2>
	<a href="ViewNotes.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">view</a>
		<a href="ViewNotes.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">update</a>
			<a href="delete.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-danger">delete</a>
		
	
	</div>
	</div>
	</div>
</div>


<%}%>
<%}%>
</div>
</div>

</body>
</html>