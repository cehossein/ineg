<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to your Home Page</title>
 </head>
   
<%--    <% String hidden = request.getParameter("inputName"); %>
The Hidden Value is <%=hidden %> --%>
<body>
	<% String type = (String)request.getAttribute("type");%>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username",username); %>
	<% session.setAttribute("type",type); %>
	<% int resume_id = (int)request.getAttribute("resume_id");%>
	<% session.setAttribute("resume_id",(Integer)resume_id); %>
	
	<% if(type.equals("Employee")) {%>
	
		<div id = "Employee"  align="center">
		     
			 <a href="sign">Update Your Profile</a> 
			 <p>Update Your Resume</p>
			 
			<form:form method="POST" modelAttribute="user" action="updateIndividualDescription"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Individual Description"></td> 
           		</tr>
            	
        	</table> 
    		</form:form> 
    		
    		<form:form method="POST" modelAttribute="user" action="updateContactDescription"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Contact Description"></td> 
           		</tr>
            	
        	</table> 
    		</form:form>
    		
    		<form:form method="POST" modelAttribute="user" action="updateOther"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Your Other Resume Properties"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
    		
    		<form:form method="POST" modelAttribute="user" action="updateWorkHistory"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Your Work History"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
    					 
    					 
    		<form:form method="POST" modelAttribute="user" action="searchInAdvertise"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Search In Advertise"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
			 
			 <form:form method="POST" modelAttribute="user" action="sendResumeToEmployer"> 
              <table> 
              	<tr>               
 				<td> <input name="username" type="hidden" value= <%=username %> /> </td> 
				</tr>
            	<tr>
                <td><input type="submit"  value="Click to Send Your Resume To Employer"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
	<% }else{  %>
		<div id = "Employer" > 
			
			EmPLOYER 
		</div>
	<%}; %>
</body>
  </html>