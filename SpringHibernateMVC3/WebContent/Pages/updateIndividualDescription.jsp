<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Individual Description</title>
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
	
	<a class="easyui-linkbutton" href="HomePage">برگشت به صفحه خانگی</a>		
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="صفحه بروز رسانی مشخصات شخصی" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
	    <form:form id="ff" method="post" action= "executeUpdateIndividualDescription"  modelAttribute="individualDescription" >
	    	<h1>مشخصات شخصی کاربر</h1>
	    	<table cellpadding="5">
	    	                <tr>
                       <th>نام</th>   <td> <input class="easyui-textbox" data-options="required:true" name="name" value="${individualDescription.name}"></td>
                </tr>
                <tr>
                       <th>نام خانوادگی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="lastname" value="${individualDescription.lastname}"></td>
                </tr>
                <tr>
                       <th>وضعیت تاهل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="marriagestatus" value="${individualDescription.marriagestatus}"></td>
                </tr>
                <tr>
                       <th>جنسیت</th>   <td> <input class="easyui-textbox" data-options="required:true" name="sex" value="${individualDescription.sex}"></td>
                </tr>
                <tr>
                       <th>ایمیل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="email" value="${individualDescription.email}"></td>
                </tr> 
            	<tr>
            	       <th> <input class="easyui-linkbutton" type="submit" value="لطفا برای بروز رسانی کلیک کنید">   </th>  
                       <th> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">پاک کردن</a> </th>    
           		 </tr>
            </table>
            </form:form>
        </div>
	    </div>
	<script>
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>