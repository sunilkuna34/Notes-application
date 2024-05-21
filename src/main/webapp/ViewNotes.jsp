<%@page import="com.org.dao.NotesDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%
User sessionUser=(User)session.getAttribute("userobj");

if(sessionUser ==null){
	response.sendRedirect("login.jsp");
}else{
%>
<%@ include file="components/homenavbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Viewing Notes</p>
						
							<%
							  int id=Integer.parseInt(request.getParameter("id"));
								NotesDao n=new NotesDao();
								Notes u=n.FetchNotesById(id);
						
								%>
						
						<form action="Update_Note" method="post">
							<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" value="<%=u.getTitle() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label> 
								<%-- <p> <%= u.getDescription() %></p> --%>
								<textarea rows="7" cols="38" name="description"><%=u.getDescription()%></textarea>
								</div>
								<input type="hidden" name="id" value="<%=u.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">update</button>
								
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<%} %>

</body>
</html>