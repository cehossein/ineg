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
	
	<form:form  name="updateIndividualDescriptionForm" method="post" action= "executeUpdateIndividualDescription"  modelAttribute="individualDescription" >
        <div align="center">
            <h1>Your Individual Description</h1>
            <table border="1">
                <tr>
                       <th>Your First Name</th>   <td> <input name="name" value="${individualDescription.name}"></td>
                </tr>
                <tr>
                       <th>Your Last Name</th>   <td> <input name="lastname" value="${individualDescription.lastname}"></td>
                </tr>
                <tr>
                       <th>Marriage Status</th>   <td> <input name="marriagestatus" value="${individualDescription.marriagestatus}"></td>
                </tr>
                <tr>
                       <th>Sex</th>   <td> <input name="sex" value="${individualDescription.sex}"></td>
                </tr>
                <tr>
                       <th>Email</th>   <td> <input name="email" value="${individualDescription.email}"></td>
                </tr> 
                <tr>               
 				<td> The Hidden Value is <%=username %> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Individual Description"></td> 
           		 </tr>
            </table>
        </div>
	</form:form>
</body>
</html>