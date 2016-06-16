<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Company Description</title>
</head>
<body>
	<% String type = (String)request.getAttribute("type");%>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username",username); %>
	<% session.setAttribute("type",type); %>
	<% int resume_id = (int)request.getAttribute("resume_id");%>
	<% session.setAttribute("resume_id",(Integer)resume_id); %>
	
	<form:form  name="updateContactDescriptionForm" method="post" action= "createCoDescription"  modelAttribute="company" >
        <div align="center">
            <h1>Your Company Description</h1>
            <table border="1">
                <tr>
                       <th>Company Name</th>   <td> <input name="name" value="${company.name}"></td>
                </tr>
                <tr>
                       <th>Company Email Address</th>   <td> <input name="www" value="${company.www}"></td>
                </tr>
                <tr>
                       <th>Company Address</th>   <td> <input name="address" value="${company.address}"></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Create Or Update Contact Description"></td> 
           		 </tr>
            </table>
        </div>
	</form:form>
</body>
</html>