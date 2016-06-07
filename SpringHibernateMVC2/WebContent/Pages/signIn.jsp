<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
   
	<body>
	<form:form  name="signInForm" method="post" action="signIn.do" modelAttribute="user" >
		<input name="user_id" type="hidden" value="${user.id}">
        <div align="center">
            <h1>User Detail</h1>
            <table border="1">
           
                <tr>
                       <th>User Name</th>   <td> <input name="user_name" value="${user.username}"></td>
                             
                </tr>
                <tr>
                       <th>PassWord</th>   <td> <input name="pass" value="${user.password}"></td>
                             
                </tr>
               <tr>
                       <th> <input type="submit" value="Add New User">   </th>      
                </tr>
            </table>
        </div>
	</form:form>
</body>
    
  </html>