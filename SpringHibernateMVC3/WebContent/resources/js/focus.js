/* 	<p>Your name : <input type="text" id = "name"/> <span id = "name_span"/></p>
	<p>Your age : <input type="text" id = "age"/>  <span id = "age_span"/></p>
$('#name').focusin(function(){
	$('#name_span').html('Enter your name');
});
$('#name').focusout(function(){
	$('#name_span').html('');
});
$('#age').focusin(function(){
	$('#age_span').html('Enter your age');
});
$('#age').focusout(function(){
	$('#age_span').html('');
}); */