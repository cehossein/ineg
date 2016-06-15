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
	<% String type = (String)request.getAttribute("type");%>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username",username); %>
	<% session.setAttribute("type",type); %>
	<% int resume_id = (int)request.getAttribute("resume_id");%>
	<% session.setAttribute("resume_id",(Integer)resume_id); %>
	<% int contactDescrptionId = (int)request.getAttribute("contactDescrptionId"); %>
	<% session.setAttribute("contactDescrptionId",(Integer)contactDescrptionId); %>
	

	<form:form  name="updateOtherForm" method="post" action= "executeCreateOtherProperties"  modelAttribute="advertise" >
        <div align="center">
            <h1>Advertise Other Properties</h1>
            <table border="1">
                <tr>
                       <th>Date</th>   <td> <input name="PropagateDate" value="${advertise.propagate_date}" /></td>
                </tr>
                <tr>
                       <th>Company Name</th>   <td> <input name="CoName" value="${advertise.co_name}" /></td>
                </tr>
                <tr>
                       <th>Wage</th>   <td> <input name="wage" value="${advertise.wage}" /></td>
                </tr>
                <tr>
                       <th>Title</th>   <td> <input name="Title" value="${advertise.title}" /></td>
                </tr>
                <tr>
                       <th>Advertise Text</th>   <td> <input name="AdvText" value="${advertise.adv_text}" /></td>
                </tr>
                <tr>
                       <th>Job Address</th>   <td> <input name="CityName" value="${advertise.city_name}" /></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Create Other Properties For Your Adv." /></td> 
           		 </tr>
            </table>
        </div>
	</form:form>
</body>
</html>