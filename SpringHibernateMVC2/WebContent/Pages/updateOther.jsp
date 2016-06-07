<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Individual Description</title>
</head>
<body>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username", username); %>
	
	<form:form  name="updateOtherForm" method="post" action= "executeUpdateOther"  modelAttribute="resume" >
        <div align="center">
            <h1>Your Other Resume Properties</h1>
            <table border="1">
                <tr>
                       <th>Your Favorite City Name</th>   <td> <input name=favoritycity value="${resume.favoritycity}"></td>
                </tr>
                <tr>
                       <th>Your Favorite Job Name</th>   <td> <input name="favorityjob" value="${resume.favorityjob}"></td>
                </tr>
                <tr>
                       <th>Your Requested Wage</th>   <td> <input name="requestedwage" value="${resume.requestedwage}"></td>
                </tr>
                <tr>               
 				<td> The Hidden Value is <%=username %> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Your Other Resume Properties"></td> 
           		 </tr>
            </table>
        </div>
	</form:form>
</body>
</html>