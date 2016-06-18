<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Failed</title>
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
<a class="easyui-linkbutton" href="HomePage">برگشت به صفحه خانگی</a>	
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="صفحه خطای ورود کاربر" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
        </div>
        	<h2>لطفا مجددا با نام کاربری و رمز عبور صحیح به سایت وارد شوید</h2>
        	<a class="easyui-linkbutton" href="login">تلاش مجدد</a>
        	<h2> اگر عضو سایت ما نشده اید، لطفا ابتدا ثبت نام کنید</h2>
        	<a class="easyui-linkbutton" href ="sign"> ثبت نام </a>
        	
        	<h2>با تشکر</h2>
	    </div> 
</body>
</html>