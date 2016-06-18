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
	<% int contactDescrptionId = (int)request.getAttribute("contactDescrptionId"); %>
	<% session.setAttribute("contactDescrptionId",(Integer)contactDescrptionId); %>
	

	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="صفحه ایجاد مشخصات آگهی" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
	    <form:form id="ff" method="post" action= "executeCreateOtherProperties"  modelAttribute="advertise" >
	    	<h1>مشخصات آگهی</h1>
	    	<table cellpadding="5">
	    	    <tr>
                       <th>تاریخ انتشار آگهی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="PropagateDate" value="${advertise.propagate_date}" ></td>
                </tr>

                <tr>
                       <th>نام شرکت آگهی دهنده</th>   <td> <input class="easyui-textbox" data-options="required:true" name="CoName" value="${advertise.co_name}" ></td>
                </tr> 
                <tr>
                       <th>میزان حقوق پیشنهادی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="wage" value="${advertise.wage}"></td>
                </tr>
                <tr>
                       <th>عنوان شغلی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="Title" value="${advertise.title}"></td>
                </tr>
                <tr>
                       <th>شرح آگهی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="AdvText" value="${advertise.adv_text}"></td>
                </tr>
                <tr>
                       <th>آدرس محل کار</th>   <td> <input class="easyui-textbox" data-options="required:true" name="CityName" value="${advertise.city_name}" /></td>
                </tr>
            	<tr>
            	       <th> <input class="easyui-linkbutton" type="submit" value="لطفا برای ایجاد، کلیک کنید">   </th>  
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