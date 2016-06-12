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
	<% Object exist_item = request.getAttribute("item");%>
	<% session.setAttribute("exist_item",exist_item); %>
    <a href="HomePage">   Go To Home Page   </a>
    
	<form:form  name="updateIndividualDescriptionForm" method="post" action= "executeUpdateIndividualDescriptionUpdate"  modelAttribute="item" >
       <input name="id" type="hidden" value="${item.id}">
        <div align="center">
            <h1>Your Individual Description</h1>
            <table border="1">  
                <tr>
                       <th>Your First Name</th>   <td> <input name="name" value="${item.name}"></td>
                </tr>
                <tr>
                       <th>Your Last Name</th>   <td> <input name="lastname" value="${item.lastname}"></td>
                </tr>
                <tr>
                       <th>Marriage Status</th>   <td> <input name="marriagestatus" value="${item.marriagestatus}"></td>
                </tr>
                <tr>
                       <th>Sex</th>   <td> <input name="sex" value="${item.sex}"></td>
                </tr>
                <tr>
                       <th>Email</th>   <td> <input name="email" value="${item.email}"></td>
                </tr> 
            	<tr>
                <td><input type="submit"  value="Click to Update Individual Description"></td> 
           		 </tr>
            </table>
        </div>
	</form:form>

         <div align="center">
            <h1>Individual Description </h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Marriage Statues</th>
                <th>Sex</th>
                <th>Email</th>
                <th>Action</th>
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.lastname}</td>
                    <td>${item.marriagestatus}</td>
                    <td>${item.sex}</td>
                    <td>${item.email}</td>
                    <td><a href="editIndividualDescription?id=${item.id}">Edit</a></td>                             
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>