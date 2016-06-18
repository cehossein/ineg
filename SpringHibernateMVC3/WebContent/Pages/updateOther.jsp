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
	<div class="easyui-panel" title="صفحه بروز رسانی رزومه" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
	    <form:form id="ff" method="post" action= "executeUpdateOther"  modelAttribute="resume" >
	    	<h1>مشخصات</h1>
	    	<table cellpadding="5">
                <tr>
                       <th>نام شهر مورد نظر</th>   <td> <input class="easyui-textbox" data-options="required:true" name=favoritycity value="${resume.favoritycity}"></td>
                </tr>
                <tr>
                       <th>نام شغل مورد نظر</th>   <td> <input class="easyui-textbox" data-options="required:true" name="favorityjob" value="${resume.favorityjob}"></td>
                </tr>
                <tr>
                       <th>میزان حقوق در خواستی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="requestedwage" value="${resume.requestedwage}"></td>
                </tr>
            	<tr> 
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