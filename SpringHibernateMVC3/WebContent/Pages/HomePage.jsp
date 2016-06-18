<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to your Home Page</title>
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
   
<%--    <% String hidden = request.getParameter("inputName"); %>
The Hidden Value is <%=hidden %> --%>
<body>
	<% String type = (String)request.getAttribute("type");%>
	<% String username = (String)request.getAttribute("username");%>
	<% session.setAttribute("username",username); %>
	<% session.setAttribute("type",type); %>
	<% int resume_id = (int)request.getAttribute("resume_id");%>
	<% session.setAttribute("resume_id",(Integer)resume_id);%>


	
	<% if(type.equals("Employee")) {%>
		<div  style="margin:20px 0 10px 0;"></div>
		<div align = "center" class="easyui-accordion" style="width:500;height:300;">
		<div title=" خوش آمدید" data-options="iconCls:'icon-ok'" align="center" style="overflow:auto;padding:10px;">
			<h1 style="color:#0099FF;"> صفحه خانگی</h1>
			<h2>در این صفحه می توانید به راحتی پروفایل خود را مدیریت کنید </h2>
		</div>
		<div title="ویرایش اطلاعات شخصی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<form:form method="POST" modelAttribute="user" action="updateIndividualDescription"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		</tr>
        	</table> 
    		</form:form> 
		</div>
		<div title="ویرایش اطلاعات تماس" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateContactDescription"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		</tr>
            	
        	</table> 
    		</form:form>
		</div>
		<div title="ویرایش اطلاعات روزمه" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateOther"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		
		<div title="ویرایش رزومه کاری" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateWorkHistory"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		<div title="ویرایش رزومه آموزشی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateEducationalHistory"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		<div title="ویرایش مهارت ها" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateSkills"> 
              <table>
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		 </tr>
        	</table> 
    		</form:form>
		</div>
		<div title="جستجو در آگهی های شغلی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="searchInAdvertise"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		<div title="ارسال رزومه" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			 <form:form method="POST" modelAttribute="user" action="sendResumeToEmployer"> 
              <table>
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		</div>
	<% }else{  %>
	<div  style="margin:20px 0 10px 0;"></div>
		<div align = "center" class="easyui-accordion" style="width:500;height:300;">
		<div title=" خوش آمدید" data-options="iconCls:'icon-ok'" align="center" style="overflow:auto;padding:10px;">
			<h3 style="color:#0099FF;"> صفحه خانگی</h3>
			<p>در این صفحه می توانید به راحتی پروفایل خود را مدیریت کنید </p>
		</div>
		<div title="ویرایش اطلاعات شخصی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<form:form method="POST" modelAttribute="user" action="updateIndividualDescription"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		</tr>
            	
        	</table> 
    		</form:form> 
		</div>
		
		
		
		<div title="صفحه شخصی شرکت" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateCoDescription"> 
              <table>
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="برای ساخت صفحه شخصی برای شرکت خود کلیک کنید"></td> 
           		</tr>
            	
        	</table> 
    		</form:form>
		</div>
		
		
		<div title="ویرایش رزومه کاری" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    		<form:form method="POST" modelAttribute="user" action="updateWorkHistory"> 
              <table> 
            	<tr>
                <td><input class="easyui-textbox" type="submit"  value="لطفا برای بروز رسانی کلیک کنید"></td> 
           		 </tr>
            	
        	</table> 
    		</form:form>
		</div>
		
		<div title="ایجاد آگهی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
		    <div align="center" >
		    <h2> لطفا ابتدا مشخصات تماس آگهی را ایجاد کنید </h2>
    		<a class="easyui-linkbutton" href = "contactDescription" > کلیک کنید</a>
    		</div>
		</div>
		
		<div title="جستجو در رزومه های ارسالی" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
		    <div align="center" >
		    <h2> لطفا عنوان شغلی را برای جستجو وارد کنید </h2>
    		<div>
    		<form action="searchResumesBySkill">
    		<input class="easyui-textbox" data-options="required:true" type = "text"  name = "search_word" />
    		<input class="easyui-textbox" type = "submit" value = "Search" />
    		</form>
    		</div>
    		</div>
		</div>
		</div>
	<%}; %>
</body>
  </html>