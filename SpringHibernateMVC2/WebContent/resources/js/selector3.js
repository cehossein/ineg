/* 	<table class="myclass">
	
		<tr><td>First row</td><td>First row</td><td>First row</td><td>First row</td></tr>
		<tr><td>Second row</td><td>Second row</td><td>Second row</td><td>Second row</td></tr>
		<tr><td>Third row</td><td>Third row</td><td>Third row</td><td>Third row</td></tr>
		<tr><td>Fourth row</td><td>Fourth row</td><td>Fourth row</td><td>Fourth row</td></tr>
		
	</table>
$(document).ready(function(){
	$('.myclass tr:odd').addClass('light');
	$('.myclass td:even').addClass('dark');
}); */

/* <p>Name</p> <input type= "text"/>
	<p>Email</p> <input type = "email"/>
$('document').ready(function(){
	var default_email = 'Enter your email address';
	$('input[type="email"]').attr('value',default_email).focus(function(){
		if($(this).val() == default_email){
			$(this).attr('value','');
			$(this).css('forgroundColor','blue');
		}
			
		
	});
	$('input[type="email"]').blur(function(){
		$(this).attr('value',default_email);
		$(this).css('backgroundColor','orange');
	});
}); */

/* 	<input type= "text"/>
	<ul id="mylist" class="mylist">
		<li>one</li>
		<li>two</li>
		<li>three</li>
		<li>four</li>
	</ul>
$(document).ready(function(){
	$(':text').keyup(function(){
		var search_name;
		search_name = $(this).val();
		
		$('#mylist li').removeClass('mylight');
		
		if(search_name != '')
			$("#mylist li:contains('" + search_name + "')").addClass('mylight');
	});
}); */