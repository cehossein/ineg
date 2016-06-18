<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Work History</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/jquery2.js" />"></script>
    <script src="<c:url value="/resources/js/click.js" />"></script>
    
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/themes/default/easyui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/themes/icon.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/demo.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery-easyui-1.4.4/jquery.min.js" />"></script>   
	<script src="<c:url value="/resources/jquery-easyui-1.4.4/jquery.easyui.min.js" />"></script>   
	
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
            <div align="center">
            <h1>Resume Result List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>ID</th>
            <!--     <th>Finish Date</th>
                <th>Work Field</th>
                <th>Department Name</th>
                <th>Last Reward</th>
                <th>Action</th>
                <th>Action</th> -->
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.id}</td>
                    <%-- <td>${item.finishdate}</td>
                    <td>${item.workfield}</td>
                    <td>${item.departmentname}</td>
                    <td>${item.lastreward}</td> --%>
                    <%-- <td><a href="editWorkHistory?startdate=${item.startdate}&finishdate=${item.finishdate}&departmentname=${item.departmentname}">Edit</a></td>  
                   <!--  url mishe : 
                    edit?id=....  injori mikhad parameter ha ro daste 
                    controller edit beresone -->
    				<td><a href="deleteWorkHistory?startdate=${item.startdate}&finishdate=${item.finishdate}&departmentname=${item.departmentname}">Delete</a></td>  
                     --%>         
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>