<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
	<%-- <% session.setAttribute("pa", "pppp"); %> --%>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="به صفحه ورود به سامانه خوش آمدید" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form:form id="ff" method="post" action="executeLogin" modelAttribute="user">
	    	<h1>مشخصات کاربر</h1>
	    	<table cellpadding="5">
	    		<tr>
                       <th>نام کاربری</th>   <td> <input class="easyui-textbox" data-options="required:true" name="username" value="${user.username}"></td>
                             
                </tr>
                <tr>
                       <th>رمز عبور</th>   <td> <input class="easyui-textbox" type="password" data-options="required:true" name="password" value="${user.password}"></td>
                             
                </tr>
               <tr>
                       <th> <input class="easyui-linkbutton" type="submit" value="ورود">   </th>  
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