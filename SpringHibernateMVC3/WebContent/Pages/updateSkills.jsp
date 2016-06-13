<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Skills</title>
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
    <body>
    <a href="HomePage">   Go To Home Page   </a>
    <form:form name="updateSkillsFormUpdate" method="post" action="executeUpdateSkillsUpdate" modelAttribute="item">
        <div align="center">
            <h1>Skill Detail</h1>
            <table border="1">
                <tr>
                       <th>Skill name</th>   <td> <input name="name" value="${item.name}"></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Skill Name"></td> 
           		 </tr>
            </table>
        

        </form:form>
    <form:form name="updateSkillsFormAdd" method="post" action="executeUpdateSkillsAdd" modelAttribute="additem">
        
            <h1>Skill Detail</h1>
            <table border="1">
                <tr>
                       <th>Skill name</th>   <td> <input name="name" value="${additem.name}"></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Add Item To Your Skills"></td> 
           		 </tr>
            </table>
        </div>

        </form:form>
        
         <div align="center">
            <h1>Skill List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Skill name</th>
                <th>Action</th>
                <th>Action</th>
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.name}</td>
                    <td><a href="editSkills?id=${item.id}">Edit</a></td>  
                   
    				<td><a href="deleteSkills?id=${item.id}">Delete</a></td>  
                             
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>