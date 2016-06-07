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
	
	<form:form  name="updateContactDescriptionForm" method="post" action= "executeUpdateContactDescription"  modelAttribute="contactDescription" >
        <div align="center">
            <h1>Your Contact Description</h1>
            <table border="1">
                <tr>
                       <th>Your Phone Number</th>   <td> <input name="phone" value="${contactDescription.phone}"></td>
                </tr>
                <tr>
                       <th>Your Email Address</th>   <td> <input name="email" value="${contactDescription.email}"></td>
                </tr>
                <tr>
                       <th>Your Address</th>   <td> <input name="address" value="${contactDescription.address}"></td>
                </tr>
                <tr>               
 				<td> The Hidden Value is <%=username %> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Contact Description"></td> 
           		 </tr>
            </table>
        </div>
	</form:form>
</body>
</html>