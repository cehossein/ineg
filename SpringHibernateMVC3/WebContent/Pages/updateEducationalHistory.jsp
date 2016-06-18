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
    
    <a class="easyui-linkbutton" href="HomePage">برگشت به صفحه خانگی</a>
    <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="صفحه بروز رسانی رزومه آموزشی" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
	    <form:form id="ff"  method="post" action="executeUpdateEducationalHistoryUpdate" modelAttribute="item" >
	    	<h1>مشخصات آموزشی</h1>
	    	<table cellpadding="5">
	    		<tr>
                       <th>رشته تحصیلی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="studyfield" value="${item.studyfield}"></td>
                </tr>
                <tr>
                       <th>مقطع تحصیلی</th>   <td> <input class="easyui-textbox" data-options="required:true" name=grade value="${item.grade}"></td>
                </tr>
                <tr>
                       <th>گرایش</th>   <td> <input class="easyui-textbox" data-options="required:true" name="academicorientation" value="${item.academicorientation}"></td>
                </tr>
                <tr>
                       <th>نام محل تحصیل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="universityname" value="${item.universityname}"></td>
                </tr>
                <tr>
                       <th>تاریخ شروع</th>   <td> <input class="easyui-textbox" data-options="required:true" name="startdate" value="${item.startdate}"></td>
                </tr> 
                <tr>
                       <th>تاریخ پایان</th>   <td> <input class="easyui-textbox" data-options="required:true" name="finishdate" value="${item.finishdate}"></td>
                </tr>
                <tr>
                       <th>معدل کل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="average" value="${item.average}"></td>
                </tr>
            	<tr>
            	       <th> <input class="easyui-linkbutton" type="submit" value="لطفا برای بروز رسانی کلیک کنید">   </th>  
                       <th> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">پاک کن</a> </th>    
           		 </tr>
            </table>
            </form:form>
        </div>
	    </div>

	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="صفحه افزودن به رزومه آموزشی" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
			<form:form id="ff2" method="post" action="executeUpdateEducationalHistoryAdd" modelAttribute="additem">
	    	<h1>مشخصات آموزشی</h1>
	    	<table cellpadding="5">
	    		<tr>
                       <th>رشته تحصیلی</th>   <td> <input class="easyui-textbox" data-options="required:true" name="studyfield" value="${additem.studyfield}"></td>
                </tr>
                <tr>
                       <th>مقطع تحصیلی</th>   <td> <input class="easyui-textbox" data-options="required:true" name=grade value="${additem.grade}"></td>
                </tr>
                <tr>
                       <th>گرایش</th>   <td> <input class="easyui-textbox" data-options="required:true" name="academicorientation" value="${additem.academicorientation}"></td>
                </tr>
                <tr>
                       <th>نام محل تحصیل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="universityname" value="${additem.universityname}"></td>
                </tr>
                <tr>
                       <th>تاریخ شروع</th>   <td> <input class="easyui-textbox" data-options="required:true" name="startdate" value="${additem.startdate}"></td>
                </tr> 
                <tr>
                       <th>تاریخ پایان</th>   <td> <input class="easyui-textbox" data-options="required:true" name="finishdate" value="${additem.finishdate}"></td>
                </tr>
                <tr>
                       <th>معدل کل</th>   <td> <input class="easyui-textbox" data-options="required:true" name="average" value="${additem.average}"></td>
                </tr>
            	<tr>
            	       <th> <input class="easyui-linkbutton" type="submit" value="لطفا برای اضافه کردن این مورد کلیک کنید">   </th>  
                       <th> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">پاک کن</a> </th>    
           		 </tr>
            </table>
            </form:form>
		</div>
		</div>
	    <div style="margin:20px 0;"></div> 
	 <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="اطلاعات فعلی رزومه آموزشی شما" style="width:500;">
		<div style="padding:10px 60px 20px 60px">
		<table border="1">
            <tr>
                <th>شماره</th>
                <th>رشته تحصیلی</th>
                <th>مقطع تحصیلی</th>
                <th>گرایش</th>
                <th>نام محل تحصیل</th>
                <th>تاریخ شروع</th>
                <th>تاریخ پایان</th>
                <th>معدل کل</th>
                <th>عملکرد</th>
                <th>عملکرد</th>
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
                    <td><a href="editEducationalHistory?studyfield=${item.studyfield}&grade=${item.grade}&academicorientation=${item.academicorientation}">ویرایش</a></td>  
                   
    				<td><a href="deleteEducationalHistory?studyfield=${item.studyfield}&grade=${item.grade}&academicorientation=${item.academicorientation}">حذف</a></td>  
                             
                </tr>
                </c:forEach>             
            </table>
        
        </div>
	    </div>           
    <script>
		function clearForm(){
			$('#ff').form('clear');
		}
		function clearForm(){
			$('#ff2').form('clear');
		}
	</script>
    </body>
</html>