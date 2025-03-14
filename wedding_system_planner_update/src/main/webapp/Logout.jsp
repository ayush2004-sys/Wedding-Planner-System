<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<%
	HttpSession currentsession =request.getSession(false);

		if(currentsession != null)
		{
			currentsession.invalidate();
		}
	response.sendRedirect("index.html");
%>
<body>

</body>
</html>