/* <textarea maxlength= "100" id= "textarea"> </textarea>
<div id= "feedback" />
$('document').ready(function(){
	var maxlen = 100;
	$('#feedback').html(' max character that you can write is ' + maxlen);
	$('#textarea').keyup(function(){
		var newlen = $('#textarea').val().length;
		var remainlen = maxlen - newlen;
		$('#feedback').html(' max character that you can write is ' + remainlen);
	});
}); */
/* $('document').ready(function(){
	var maxlen = 100;
	var newlen = $('#textarea').val().length;
	var remainlen = maxlen - newlen;
	$('#feedback').html(' max character that you can write is ' + remainlen);
});
این کد اولا مقدار اولیه 99 رو نشون میده به جای 100
ثانیا با نوشتن آپدیت نمیشه چون گفتی در خط اول که هر موقع داکیومنت آماده شد نه اینکه هر موقع کلیدی رها شداین کد تازه سازی بشه */