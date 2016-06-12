<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Your Resume</title>
   
	<body>
	
	<% String type = (String)request.getAttribute("type");%>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username",username); %>
	<% session.setAttribute("type",type); %>
	<% int resume_id = (int)request.getAttribute("resume_id");%>
	<% session.setAttribute("resume_id",(Integer)resume_id); %>
	
	<form:form  name="resumeForm" method="post" action="resumeUpdate" modelAttribute="resume" >
        <div align="center">
            <h1>Resume</h1>
            <table border="1">
                <tr>
                       <th>Favoritiy City Name</th>   <td> <input name="favoritycity" value="${resume.favoritycity}"></td>        
                </tr>
                <tr>
                       <th>Favority Job</th>   <td> <input name="favorityjob" value="${resume.favorityjob}"></td>
                </tr>
                <tr>
                       <th>Requested Wage</th>   <td> <input name="requestedwage" value="${resume.requestedwage}"></td>
                </tr>
                <tr>
                       <th>Name</th>   <td> <input name="name" value="${resume.name}"></td>
                </tr>
                <tr>
                       <th>Last Name</th>   <td> <input name="lastname" value="${resume.lastname}"></td>
                </tr>
                <tr>
                       <th>Marriage Status</th>   <td> <input name="marriagestatus" value="${resume.marriagestatus}"></td>
                </tr>
                <tr>
                       <th>Sex</th>   <td> <input name="sex" value="${resume.sex}"></td>
                </tr>
                <tr>
                       <th>Email</th>   <td> <input name="email" value="${resume.email}"></td>
                </tr>
                <tr>
                       <th>User Type</th>   <td><select name="type"> 
                       							<option value="Employee">Employee</option>
 												<option value="Employer">Employer</option>
												</select>
                        					</td>
                </tr>
               <tr>
                       <th> <input type="submit" value="Add New User">   </th>      
                </tr>
            </table>
        </div>
	</form:form>
	</body>
    
  </html>