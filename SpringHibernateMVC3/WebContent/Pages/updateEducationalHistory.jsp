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
    <body>
    <a href="HomePage">   Go To Home Page   </a>
    <form:form name="updateEducationalHistoryFormUpdate" method="post" action="executeUpdateEducationalHistoryUpdate" modelAttribute="item">
        <div align="center">
            <h1>Educational History Detail</h1>
            <table border="1">
                <tr>
                       <th>Your Study Field</th>   <td> <input name="studyfield" value="${item.studyfield}"></td>
                </tr>
                <tr>
                       <th>Your Grade</th>   <td> <input name=grade value="${item.grade}"></td>
                </tr>
                <tr>
                       <th>Your Academic Orientation</th>   <td> <input name="academicorientation" value="${item.academicorientation}"></td>
                </tr>
                <tr>
                       <th>Your University Name</th>   <td> <input name="universityname" value="${item.universityname}"></td>
                </tr>
                <tr>
                       <th>Your Start Date</th>   <td> <input name="startdate" value="${item.startdate}"></td>
                </tr> 
                <tr>
                       <th>Your Finish Date</th>   <td> <input name="finishdate" value="${item.finishdate}"></td>
                </tr>
                <tr>
                       <th>Your Average</th>   <td> <input name="average" value="${item.average}"></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Update Educational History"></td> 
           		 </tr>
            </table>
        

        </form:form>
    <form:form name="updateEducationalHistoryFormAdd" method="post" action="executeUpdateEducationalHistoryAdd" modelAttribute="additem">
        
            <h1>Educational History Detail</h1>
            <table border="1">
                <tr>
                       <th>Your Study Field</th>   <td> <input name="studyfield" value="${additem.studyfield}"></td>
                </tr>
                <tr>
                       <th>Your Grade</th>   <td> <input name=grade value="${additem.grade}"></td>
                </tr>
                <tr>
                       <th>Your Academic Orientation</th>   <td> <input name="academicorientation" value="${additem.academicorientation}"></td>
                </tr>
                <tr>
                       <th>Your University Name</th>   <td> <input name="universityname" value="${additem.universityname}"></td>
                </tr>
                <tr>
                       <th>Your Start Date</th>   <td> <input name="startdate" value="${additem.startdate}"></td>
                </tr> 
                <tr>
                       <th>Your Finish Date</th>   <td> <input name="finishdate" value="${additem.finishdate}"></td>
                </tr>
                <tr>
                       <th>Your Average</th>   <td> <input name="average" value="${additem.average}"></td>
                </tr>
            	<tr>
                <td><input type="submit"  value="Click to Add Educational History"></td> 
           		 </tr>
            </table>
        </div>

        </form:form>
        
         <div align="center">
            <h1>Educational History List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Study Field</th>
                <th>Grade</th>
                <th>Academic Orientation</th>
                <th>University Name</th>
                <th>Start Date</th>
                <th>Finish Date</th>
                <th>Average</th>
                <th>Action</th>
                <th>Action</th>
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.studyfield}</td>
                    <td>${item.grade}</td>
                    <td>${item.academicorientation}</td>
                    <td>${item.universityname}</td>
                    <td>${item.startdate}</td>
                    <td>${item.finishdate}</td>
                    <td>${item.average}</td>
                    <td><a href="editEducationalHistory?studyfield=${item.studyfield}&grade=${item.grade}&academicorientation=${item.academicorientation}">Edit</a></td>  
                   
    				<td><a href="deleteEducationalHistory?studyfield=${item.studyfield}&grade=${item.grade}&academicorientation=${item.academicorientation}">Delete</a></td>  
                             
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>