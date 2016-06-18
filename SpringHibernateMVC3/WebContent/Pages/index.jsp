<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Our Site</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/jquery2.js" />"></script>
    <script src="<c:url value="/resources/js/click.js" />"></script>
    
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/themes/default/easyui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/themes/icon.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery-easyui-1.4.4/demo.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery-easyui-1.4.4/jquery.min.js" />"></script>   
	<script src="<c:url value="/resources/jquery-easyui-1.4.4/jquery.easyui.min.js" />"></script>   
	
	<body>
	<div  style="margin:20px 0 10px 0;"></div>
	<div align = "center" class="easyui-accordion" style="width:500px;height:300px;">
		<div title="درباره ی سیستم" data-options="iconCls:'icon-ok'" align="center" style="overflow:auto;padding:10px;">
			<h3 style="color:#0099FF;">سیستم اتصال صنعت و دانشگاه</h3>
			<p>به سیستم ما خوش آمدید. این وب سایت به شما در پیدا کردن شغل موردعلاقه تان کمک می کند</p>
		</div>
		<div title="شروع" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<div id="Employee"  align="center" >
			<h2> خوش آمدید </h2>
			<h3> لطفا انتخاب کنید</h3>
			<table>
				<tr>
				 <td><a href="login">Login</a></td> 
				 <td><a href="sign">Sign Up</a> </td>
				 </tr>
			</table>
		</div>
		</div>
	</div>
	</body>
</html>