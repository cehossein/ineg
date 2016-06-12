<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Work History</title>
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
    <form:form name="updateWorkHistoryFormUpdate" method="post" action="executeUpdateWorkHistoryUpdate" modelAttribute="item">
        <div align="center">
            <h1>Work History Detail</h1>
            <table border="1">
                <tr>
                       <th>Your Start Date</th>   <td> <input name="startdate" value="${item.startdate}"></td>
                </tr>
                <tr>
                       <th>Your Finish Date</th>   <td> <input name="finishdate" value="${item.finishdate}"></td>
                </tr>
                <tr>
                       <th>Your Work Field</th>   <td> <input name="workfield" value="${item.workfield}"></td>
                </tr>
                <tr>
                       <th>Your Department Name</th>   <td> <input name="departmentname" value="${item.departmentname}"></td>
                </tr>
                <tr>
                       <th>Your Last Reward</th>   <td> <input name="lastreward" value="${item.lastreward}"></td>
                </tr> 
            	<tr>
                <td><input type="submit"  value="Click to Update Work History"></td> 
           		 </tr>
            </table>
        

        </form:form>
    <form:form name="updateWorkHistoryFormAdd" method="post" action="executeUpdateWorkHistoryAdd" modelAttribute="additem">
        
            <h1>Work History Detail</h1>
            <table border="1">
                <tr>
                       <th>Your Start Date</th>   <td> <input name="startdate" value="${additem.startdate}"></td>
                </tr>
                <tr>
                       <th>Your Finish Date</th>   <td> <input name="finishdate" value="${additem.finishdate}"></td>
                </tr>
                <tr>
                       <th>Your Work Field</th>   <td> <input name="workfield" value="${additem.workfield}"></td>
                </tr>
                <tr>
                       <th>Your Department Name</th>   <td> <input name="departmentname" value="${additem.departmentname}"></td>
                </tr>
                <tr>
                       <th>Your Last Reward</th>   <td> <input name="lastreward" value="${additem.lastreward}"></td>
                </tr> 
            	<tr>
                <td><input type="submit"  value="Click to Add Work History"></td> 
           		 </tr>
            </table>
        </div>

        </form:form>
        
         <div align="center">
            <h1>Work History List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Start Date</th>
                <th>Finish Date</th>
                <th>Work Field</th>
                <th>Department Name</th>
                <th>Last Reward</th>
                <th>Action</th>
                <th>Action</th>
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.startdate}</td>
                    <td>${item.finishdate}</td>
                    <td>${item.workfield}</td>
                    <td>${item.departmentname}</td>
                    <td>${item.lastreward}</td>
                    <td><a href="editWorkHistory?startdate=${item.startdate}&finishdate=${item.finishdate}&departmentname=${item.departmentname}">Edit</a></td>  
                   <!--  url mishe : 
                    edit?id=....  injori mikhad parameter ha ro daste 
                    controller edit beresone -->
    				<td><a href="deleteWorkHistory?startdate=${item.startdate}&finishdate=${item.finishdate}&departmentname=${item.departmentname}">Delete</a></td>  
                             
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>