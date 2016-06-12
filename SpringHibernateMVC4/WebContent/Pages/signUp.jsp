<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Form</title>
   
	<body>
	<form:form  name="signUpForm" method="post" action="signUp" modelAttribute="user" >
        <div align="center">
            <h1>User Sign Up</h1>
            <table border="1">
           
                <tr>
                       <th>User Name</th>   <td> <input name="username" value="${user.username}"></td>
                             
                </tr>
                <tr>
                       <th>Password</th>   <td> <input name="password" value="${user.password}"></td>
                             
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