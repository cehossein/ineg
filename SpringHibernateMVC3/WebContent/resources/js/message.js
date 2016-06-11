/* <a href= "#" id = "showhide" > Hide </a>
<div id= "message" > God </div>
$('#showhide').toggle(function(){
	$(this).text('Show');
} , function(){
	$(this).text('Hide');
} );

$('#showhide').click(function(){
	$('#message').toggle();
}); */

/* <a href= "#" id = "showhide" > Hide </a>
<div id= "message" > God </div>
$('#showhide').toggle(function(){
	$('#showhide').text('Show');
	$('#message').hide();
} , function(){
	$('#showhide').text('Hide');
	$('#message').show();
}); */

