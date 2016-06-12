/* 	<textarea id="text" rows="2" cols="3"> one , two , three , four , five ,  six</textarea>
	<div id="feedback"/>
$('#text').scroll(function(){
	var v = $(this).scrollTop();
	$('#feedback').html('you are in ' + v + ' positon');
}); */