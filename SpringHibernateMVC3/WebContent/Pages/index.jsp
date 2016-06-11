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

	<body>
		<div id="Employee"  align="center" > <!--  style="display: none;" with click.js -->
			<h2> Welcome </h2>
			<h3> Please Select Your Action.</h3>
			<table>
				<tr>
				 <td><a href="login">Login</a></td> 
				 <td><a href="sign">Sign Up</a> </td>
				 </tr>
			</table>
		</div>
		
		<!-- <div id="menu_link">
		<h1>menu_link</h1>
		</div> with click.js-->
		
	</body>
	
</html>